package com.toko.online.service;

import com.toko.online.model.OrderModel;

public interface OrderService {

    Object getAllOrder();
    OrderModel addOrder(OrderModel orderModel);

    OrderModel editOrder(Long id, String namaBarang, String harga, String pemilik);

    void deleteOrder(Long id);
}
