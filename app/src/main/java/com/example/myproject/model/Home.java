package com.example.myproject.model;

public class Home {
    private String productName;
    private String orderId;
    private String productStatus;

    public Home(String productName, String orderId, String productStatus) {
        this.productName = productName;
        this.orderId = orderId;
        this.productStatus = productStatus;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
}
