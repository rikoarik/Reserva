package com.reserva.employe.model;

public class StokBarangModel {

    private String Produk;
    private int Jumlah;
    private String Image;

    public StokBarangModel(String produk, int jumlah, String image) {
        Image = image;
        Produk = produk;
        Jumlah = jumlah;
    }

    public StokBarangModel() {

    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        this.Image = image;
    }


    public String getProduk() {
        return Produk;
    }

    public void setProduk(String produk) {
        Produk = produk;
    }

    public int getJumlah() {
        return Jumlah;
    }

    public void setJumlah(int jumlah) {
        Jumlah = jumlah;
    }

}
