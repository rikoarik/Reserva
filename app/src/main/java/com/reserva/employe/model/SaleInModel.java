package com.reserva.employe.model;

public class SaleInModel {

    private String Produk;
    private int Jumlah;
    private String Image;
    private String tglin;

    public SaleInModel(String produk, int jumlah, String image, String tglin) {
        Produk = produk;
        Jumlah = jumlah;
        Image = image;
        this.tglin = tglin;
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

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getTglin() {
        return tglin;
    }

    public void setTglin(String tglin) {
        this.tglin = tglin;
    }

}
