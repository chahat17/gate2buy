package com.example.myproject.model.getprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataProfile {

    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("default_language_code")
    @Expose
    private String defaultLanguageCode;
    @SerializedName("default_currency")
    @Expose
    private String defaultCurrency;
    @SerializedName("photo")
    @Expose
    private String photo;

    public DataProfile(String fullName, String defaultLanguageCode, String defaultCurrency, String photo) {
        super();
        this.fullName = fullName;
        this.defaultLanguageCode = defaultLanguageCode;
        this.defaultCurrency = defaultCurrency;
        this.photo = photo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDefaultLanguageCode() {
        return defaultLanguageCode;
    }

    public void setDefaultLanguageCode(String defaultLanguageCode) {
        this.defaultLanguageCode = defaultLanguageCode;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
