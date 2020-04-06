package com.example.myproject.model.getprofile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProfileResponseBody {
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
    private DataProfile dataProfile;

    private static GetProfileResponseBody getProfileResponseBody;

    private GetProfileResponseBody() {
    }

    public static GetProfileResponseBody getInstance(){
        if(getProfileResponseBody ==null){
            getProfileResponseBody =new GetProfileResponseBody();
        }
        return getProfileResponseBody;
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

    public DataProfile getDataProfile() {
        return dataProfile;
    }

    public void setDataProfile(DataProfile dataProfile) {
        this.dataProfile = dataProfile;
    }
}
