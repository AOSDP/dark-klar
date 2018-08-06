/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.aosdp.darkfocus.web;


import android.content.Context;
import android.support.annotation.NonNull;

import com.aosdp.darkfocus.architecture.NonNullObserver;
import com.aosdp.darkfocus.session.Session;

import java.util.List;

public class CleanupSessionObserver extends NonNullObserver<List<Session>> {
    private final Context context;

    public CleanupSessionObserver(Context context) {
        this.context = context;
    }

    @Override
    protected void onValueChanged(@NonNull List<Session> sessions) {
        if (sessions.isEmpty()) {
            // Make sure no browsing data remains on the device if there's no active session (anymore).
            WebViewProvider.performCleanup(context);
        }
    }
}
