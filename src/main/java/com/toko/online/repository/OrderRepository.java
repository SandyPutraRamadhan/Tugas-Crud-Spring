package com.toko.online.repository;

import com.toko.online.model.OrderModel;
import com.toko.online.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {
    Optional<OrderModel> findByPemilik(String pemilik);
}
