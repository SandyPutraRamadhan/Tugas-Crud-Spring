package com.toko.online.controller;

import com.toko.online.model.UserModel;
import com.toko.online.response.ResponHelper;
import com.toko.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    UserModel userModel;
@Autowired
    UserService userService;

@GetMapping("/{id}")
    public Object getUser(@PathVariable("id") Integer id) {
    return ResponHelper.ok(userService.getUser(id));
}

@PostMapping
    public Object addUser(@RequestBody UserModel userModel) {
        return ResponHelper.ok(userService.addUser(userModel));
}

@GetMapping
    public Object getAllUser() {
    return ResponHelper.ok(userService.getAllUser());
}

@PutMapping("/{id}")
    public Object editUser(@PathVariable("id") Integer id, @RequestBody UserModel userModel) {
    return ResponHelper.ok(userService.editUser(id, userModel.getUserName(), userModel.getEmail(), userModel.getAge(), userModel.getAddress(), userModel.getPhoneNumber()));
}

@DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
    userService.deleteUser(id);
}
}
