package com.toko.online.controller;

import com.toko.online.dto.OrderDto;
import com.toko.online.model.OrderModel;
import com.toko.online.response.ResponHelper;
import com.toko.online.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public Object getAllOrder() {
        return ResponHelper.ok(orderService.getAllOrder());
    }

    @PostMapping
    public Object addOrder(@RequestBody OrderDto orderDto) {
        return ResponHelper.ok(orderService.addOrder(modelMapper.map(orderDto, OrderModel.class)));
    }

    @PutMapping("/{id}")
    public Object editOrder(@PathVariable("id") Long id, @RequestBody OrderModel orderModel) {
        return ResponHelper.ok(orderService.editOrder(id, orderModel.getNamaBarang(), orderModel.getHarga(), orderModel.getPemilik()));
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }
}
