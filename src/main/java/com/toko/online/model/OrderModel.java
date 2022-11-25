package com.toko.online.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.toko.online.auditing.Auditable;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd-HH-mm-ss")
    @CreationTimestamp
    @Column(name = "tanggal_dibuat", updatable = false)
    private Date tanggalDibuat;
    @Column(name = "nama_barang", nullable = false)
    private String namaBarang;

    @Column(name = "Harga")
    private String harga;

    @Column(name = "pemilik", nullable = false)
    private String pemilik;

    @Override
    public String toString() {
        return "OrderModel{" +
                "id=" + id +
                ", tanggalDibuat=" + tanggalDibuat +
                ", namaBarang='" + namaBarang + '\'' +
                ", harga='" + harga + '\'' +
                ", pemilik='" + pemilik + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Date getTanggalDibuat() {
        return tanggalDibuat;
    }

    public void setTanggalDibuat(Date tanggalDibuat) {
        this.tanggalDibuat = tanggalDibuat;
    }
}
