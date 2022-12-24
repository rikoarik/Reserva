package com.reserva.employe.model;


public class ReservasiModel {

    private String emailusers;
    private String Produk;
    private String Total;
    private String DateTime;

    public ReservasiModel(String emailusers, String produk, String total, String dateTime) {
        this.emailusers = emailusers;
        Produk = produk;
        Total = total;
        DateTime = dateTime;
    }

    public ReservasiModel() {

    }

    public String getEmailusers() {
        return emailusers;
    }

    public void setEmailusers(String emailusers) {
        this.emailusers = emailusers;
    }

    public String getProduk() {
        return Produk;
    }

    public void setProduk(String produk) {
        Produk = produk;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }
}

