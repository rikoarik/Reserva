package com.reserva.users.model;

public class UsersModel {

    private String nama;
    private String notlp;
    private String email;
    private String password;

    public UsersModel(String nama, String notlp, String email, String password) {
        this.nama = nama;
        this.notlp = notlp;
        this.email = email;
        this.password = password;
    }

    public UsersModel() {

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNotlp() {
        return notlp;
    }

    public void setNotlp(String notlp) {
        this.notlp = notlp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
