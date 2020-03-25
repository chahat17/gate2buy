package com.example.myproject.model;

public class Message {
    private String productName;
    private String productinfo;
    private String productDate;

    public Message(String productName, String productinfo, String productDate) {
        this.productName = productName;
        this.productinfo = productinfo;
        this.productDate = productDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductinfo() {
        return productinfo;
    }

    public void setProductinfo(String productinfo) {
        this.productinfo = productinfo;
    }

    public String getProductDate() {
        return productDate;
    }

    public void setProductDate(String productDate) {
        this.productDate = productDate;
    }
}
