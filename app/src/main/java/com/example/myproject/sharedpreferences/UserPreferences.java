package com.example.myproject.sharedpreferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {
    private SharedPreferences userSharedPreferences;
    private SharedPreferences.Editor editor;
    private static final String USER_PREFERENCES = "user_preferences";

    private static final String KEY = "key";
    private static final String TOKEN = "Token";
    private static final String LANGUAGE = "Language";
    private static final String LANGUAGE_RESPONSE = "Language Response";

    public UserPreferences(Context context) {
        if (userSharedPreferences == null)
            userSharedPreferences = context.getSharedPreferences(USER_PREFERENCES, Activity.MODE_PRIVATE);
    }

    //...........   Getters  ...........

    public String getKey(){
        return this.userSharedPreferences.getString(KEY,"");
    }

    public String getToken(){
        return this.userSharedPreferences.getString(TOKEN,"");
    }

    public String getLanguage(){
        return this.userSharedPreferences.getString(LANGUAGE,"en");
    }

    public String getLanguageResponse(){
        return this.userSharedPreferences.getString(LANGUAGE_RESPONSE,"");
    }


    //...........   Setters  ...........

    public UserPreferences edit() {
        editor = this.userSharedPreferences.edit();
        return this;
    }

    public UserPreferences putKey(String key) {
        this.editor.putString(KEY, key);
        return this;
    }
    public UserPreferences putToken(String token) {
        this.editor.putString(TOKEN, token);
        return this;
    }
    public UserPreferences putLanguage(String language) {
        this.editor.putString(LANGUAGE, language);
        return this;
    }
    public UserPreferences putLanguageResponse(String request) {
        this.editor.putString(LANGUAGE_RESPONSE, request);
        return this;
    }

    public void apply() {
        this.editor.apply();
        this.editor = null;
    }

}
