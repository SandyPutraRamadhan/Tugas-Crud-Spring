package com.toko.online.service;

import com.toko.online.exception.InternalErrorException;
import com.toko.online.exception.NotFoundException;
import com.toko.online.model.UserModel;
import com.toko.online.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
    UserRepository userRepository;

  @Override
    public Object getUser(Integer id) {
    var respon = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Found"));
    try {
      return userRepository.save(respon);
    } catch (Exception e) {
      throw new InternalErrorException("Kesalahan Memunculkan Data");
    }
  }

  @Override
   public UserModel addUser(UserModel userModel) {
    String email = userModel.getEmail();
    var validasi = userRepository.findByEmail(email);
    if (validasi.isPresent()) {
      throw new InternalErrorException("Email Already Axist");
    }
      return userRepository.save(userModel);
  }

  @Override
    public Object getAllUser() {
    try {
      return userRepository.findAll();
    }catch (Exception e) {
      throw new InternalErrorException("User 404 Not Found");
    }
  }

  @Override
    public Object editUser(Integer id, String userName, String email, int age, String address, Integer phoneNumber) {
      UserModel userModel = userRepository.findById(id).get();
      userModel.setUserName(userName);
      userModel.setEmail(email);
      userModel.setAge(age);
      userModel.setAddress(address);
      userModel.setPhoneNumber(phoneNumber);
      return userRepository.save(userModel);
  }

  @Override
   public void deleteUser(Integer id) {
      userRepository.deleteById(id);
  }
}
