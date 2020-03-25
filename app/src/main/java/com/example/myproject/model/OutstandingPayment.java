package com.example.myproject.model;

public class OutstandingPayment {
    private String orderid;
    private String customerName;
    private String title;
    private String Total;

    public OutstandingPayment(String orderid, String customerName, String title, String total) {
        this.orderid = orderid;
        this.customerName = customerName;
        this.title = title;
        Total = total;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }
}
