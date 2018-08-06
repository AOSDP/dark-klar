package com.aosdp.darkfocus.widget;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;

import com.aosdp.darkfocus.R;

public class AboutPreference extends Preference {
    public AboutPreference(Context context, AttributeSet attrs,
                           int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final String appName = getContext().getResources().getString(R.string.app_name);
        final String title = getContext().getResources().getString(R.string.preference_about, appName);

        setTitle(title);
    }

    public AboutPreference(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
}
