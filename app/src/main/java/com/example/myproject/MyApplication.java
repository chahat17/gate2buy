package com.example.myproject;

import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;

import com.example.myproject.sharedpreferences.SharedPreferenceHelper;

import java.util.Locale;

public class MyApplication extends Application {

    private Locale locale = null;

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferenceHelper preferences = new SharedPreferenceHelper(this);

        Configuration config = getBaseContext().getResources().getConfiguration();

        String lang = preferences.getUserPreferences().getLanguage();
        String systemLocale = getSystemLocale(config).getLanguage();
        if (!"".equals(lang) && !systemLocale.equals(lang)) {
            locale = new Locale(lang);
            Locale.setDefault(locale);
            setSystemLocale(config, locale);
            updateConfiguration(config);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (locale != null) {
            setSystemLocale(newConfig, locale);
            Locale.setDefault(locale);
            updateConfiguration(newConfig);
        }
    }

    @SuppressWarnings("deprecation")
    private static Locale getSystemLocale(Configuration config) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return config.getLocales().get(0);
        } else {
            return config.locale;
        }
    }

    @SuppressWarnings("deprecation")
    private static void setSystemLocale(Configuration config, Locale locale) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocale(locale);
        } else {
            config.locale = locale;
        }
    }

    @SuppressWarnings("deprecation")
    private void updateConfiguration(Configuration config) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            getBaseContext().createConfigurationContext(config);
        } else {
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
    }
}
