package com.toko.online.service;

import com.toko.online.exception.InternalErrorException;
import com.toko.online.model.OrderModel;
import com.toko.online.model.UserModel;
import com.toko.online.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderModel addOrder(OrderModel orderModel) {
        String pemilik = orderModel.getPemilik();
        var email = orderRepository.findByPemilik(pemilik);
        if (email.isPresent()) {
            throw new InternalErrorException("Email Already Axist");
        }
        return orderRepository.save(orderModel);
    }

    @Override
    public OrderModel editOrder(Long id, String namaBarang, String harga, String pemilik) {
        OrderModel orderModel = orderRepository.findById(id).get();
        orderModel.setNamaBarang(namaBarang);
        orderModel.setHarga(harga);
        return orderRepository.save(orderModel);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Object getAllOrder() {
        try {
            return orderRepository.findAll();
        }catch (Exception e) {
            throw new InternalErrorException("Order 404 Not Found");
        }
    }
}
