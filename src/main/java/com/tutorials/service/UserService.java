package com.tutorials.service;

import com.tutorials.dtos.UserDto;

import java.util.List;

public interface UserService {


    //create user
    public UserDto createUser(UserDto userDto);

    //update user
    public  UserDto updateUser(UserDto userDto, int userId);

    //delete user
    public  String deleteUser(int userId);

    //get user by id
    public UserDto getUserById(int userId);

    //get user by email
    public UserDto getUserByEmail(String email);

    //get user by name
    public UserDto getUserByName(String name);

    //get all users
    public List<UserDto> getAllUsers();

}
