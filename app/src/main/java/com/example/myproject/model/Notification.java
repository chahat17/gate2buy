package com.example.myproject.model;

import android.widget.ImageView;

public class Notification {
    private String message;

    private String time;

    private String description;


    public Notification(String message, String time, String description) {
        this.message = message;
        this.time = time;
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
