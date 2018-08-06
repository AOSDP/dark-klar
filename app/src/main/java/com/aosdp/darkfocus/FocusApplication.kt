/* -*- Mode: Java; c-basic-offset: 4; tab-width: 20; indent-tabs-mode: nil; -*-
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.aosdp.darkfocus

import android.os.StrictMode
import android.preference.PreferenceManager
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import com.aosdp.darkfocus.locale.LocaleAwareApplication
import com.aosdp.darkfocus.session.NotificationSessionObserver
import com.aosdp.darkfocus.session.SessionManager
import com.aosdp.darkfocus.session.VisibilityLifeCycleCallback
import com.aosdp.darkfocus.telemetry.TelemetrySessionObserver
import com.aosdp.darkfocus.telemetry.TelemetryWrapper
import com.aosdp.darkfocus.utils.AdjustHelper
import com.aosdp.darkfocus.utils.AppConstants
import com.aosdp.darkfocus.web.CleanupSessionObserver

class FocusApplication : LocaleAwareApplication() {
    var visibilityLifeCycleCallback: VisibilityLifeCycleCallback? = null
        private set

    override fun onCreate() {
        super.onCreate()

        PreferenceManager.setDefaultValues(this, R.xml.settings, false)

        enableStrictMode()

        Components.searchEngineManager.apply {
            launch(CommonPool) {
                load(this@FocusApplication)
            }

            registerForLocaleUpdates(this@FocusApplication)
        }

        TelemetryWrapper.init(this)
        AdjustHelper.setupAdjustIfNeeded(this)

        visibilityLifeCycleCallback = VisibilityLifeCycleCallback(this)
        registerActivityLifecycleCallbacks(visibilityLifeCycleCallback)

        val sessions = SessionManager.getInstance().sessions
        sessions.observeForever(NotificationSessionObserver(this))
        sessions.observeForever(TelemetrySessionObserver())
        sessions.observeForever(CleanupSessionObserver(this))

        val customTabSessions = SessionManager.getInstance().customTabSessions
        customTabSessions.observeForever(TelemetrySessionObserver())
    }

    private fun enableStrictMode() {
        // Android/WebView sometimes commit strict mode violations, see e.g.
        // https://github.com/mozilla-mobile/focus-android/issues/660
        if (AppConstants.isReleaseBuild()) {
            return
        }

        val threadPolicyBuilder = StrictMode.ThreadPolicy.Builder().detectAll()
        val vmPolicyBuilder = StrictMode.VmPolicy.Builder().detectAll()

        threadPolicyBuilder.penaltyLog()
        vmPolicyBuilder.penaltyLog()

        StrictMode.setThreadPolicy(threadPolicyBuilder.build())
        StrictMode.setVmPolicy(vmPolicyBuilder.build())
    }
}
