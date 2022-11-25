package com.toko.online.dto;

import com.toko.online.model.OrderModel;

import javax.persistence.Column;

public class OrderDto {

    private String namaBarang;

    private String harga;

    private String pemilik;

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }
}
