package com.toko.online.service;


import com.toko.online.model.UserModel;

public interface UserService {

    Object getUser(Integer id);

    UserModel addUser(UserModel userModel);

    Object getAllUser();

    Object editUser(Integer id, String userName, String email, int age, String address, Integer phoneNumber);

    void deleteUser(Integer id);
}
