package com.example.myproject.model.getlanguage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetLanguageResponseBody {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private int statusCode;
    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("data")
    @Expose
    private DataLanguage dataLanguage;

    private static GetLanguageResponseBody getLanguageResponseBody;

    private GetLanguageResponseBody() {
    }

    public static GetLanguageResponseBody getInstance(){
        if(getLanguageResponseBody ==null){
            getLanguageResponseBody =new GetLanguageResponseBody();
        }
        return getLanguageResponseBody;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataLanguage getDataLanguage() {
        return dataLanguage;
    }

    public void setDataLanguage(DataLanguage dataLanguage) {
        this.dataLanguage = dataLanguage;
    }
}
