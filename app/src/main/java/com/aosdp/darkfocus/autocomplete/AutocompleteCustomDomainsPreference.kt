/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.aosdp.darkfocus.autocomplete

import android.content.Context
import android.util.AttributeSet
import com.aosdp.darkfocus.settings.LearnMoreSwitchPreference
import com.aosdp.darkfocus.utils.SupportUtils

/**
 * Switch preference for enabling/disabling autocompletion for custom domains entered by the user.
 */
class AutocompleteCustomDomainsPreference(
    context: Context?,
    attrs: AttributeSet?
) : LearnMoreSwitchPreference(context, attrs) {
    override fun getLearnMoreUrl() = SupportUtils.getSumoURLForTopic(context, SupportUtils.SumoTopic.AUTOCOMPLETE)
}
