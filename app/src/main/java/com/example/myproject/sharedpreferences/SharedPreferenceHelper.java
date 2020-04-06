package com.example.myproject.sharedpreferences;

import android.content.Context;

public class SharedPreferenceHelper {
    private UserPreferences userPreferences;

    public SharedPreferenceHelper(Context context) {
        if (userPreferences == null)
            userPreferences = new UserPreferences(context);
    }

    public UserPreferences getUserPreferences() {
        return userPreferences;
    }
}
