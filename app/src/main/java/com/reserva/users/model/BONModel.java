package com.reserva.users.model;

public class BONModel {
    private String produk;
    private String harga;

    public BONModel(String produk, String harga) {
        this.produk = produk;
        this.harga = harga;
    }

    public BONModel() {

    }

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
