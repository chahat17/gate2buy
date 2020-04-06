package com.example.myproject.model.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponseBody {
    private static LoginResponseBody loginResponseBody;

    private LoginResponseBody() {

    }

    public static  LoginResponseBody getInstance(){
        if(loginResponseBody==null){
            loginResponseBody=new LoginResponseBody();
        }
        return loginResponseBody;
    }

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private LoginDataRes data;


//    public LoginResponseBody(String status, Integer statusCode, String message, LoginDataRes data) {
//        this.status = status;
//        this.statusCode = statusCode;
//        this.message = message;
//        this.data = data;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoginDataRes getData() {
        return data;
    }

    public void setData(LoginDataRes data) {
        this.data = data;
    }

}
