package com.example.belirumah.model;

public class User {
    private String id, name, email, nomerhp, alamat, kode;


    public User(String name, String email, String nomerHp, String alamat, String kode){
        this.name = name;
        this.email = email;
        this.nomerhp = nomerHp;
        this.alamat = alamat;
        this.kode = kode;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomerHp() {
        return nomerhp;
    }

    public void setNomerHp (String nomerHp) { this.nomerhp = nomerHp; }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) { this.alamat = alamat; }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }


}

