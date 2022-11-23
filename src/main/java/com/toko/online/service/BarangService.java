package com.toko.online.service;

import com.toko.online.model.BarangModel;
import com.toko.online.model.UserModel;

public interface BarangService {

    Object getBarang(Integer id);

    Object addBarang(BarangModel barangModel);

    Object getAllBarang();

    Object editBarang(Integer id, String name, float price, int count, int rating, String description, boolean publish);

    void deleteBarang(Integer id);
}
