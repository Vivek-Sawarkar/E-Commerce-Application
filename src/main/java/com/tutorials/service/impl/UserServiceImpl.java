package com.tutorials.service.impl;

import com.tutorials.dtos.UserDto;
import com.tutorials.exception.ResourceNotFoundException;
import com.tutorials.models.User;
import com.tutorials.repository.UserRepository;
import com.tutorials.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.toUserEntity(userDto);
        User user1 = this.userRepository.save(user);
        UserDto userDto1 = this.toUserDto(user1);
        return userDto1;
    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User is  not available in database...."));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setGender(userDto.getGender());
        user.setPhoneNo(userDto.getPhoneNo());
        user.setCreatedAt(userDto.getCreatedAt());
        user.setAbout(userDto.getAbout());
        user.setActive(userDto.isActive());
        user.setAddress(userDto.getAddress());

        User savedUser = this.userRepository.save(user);
        return this.toUserDto(savedUser);
    }

    @Override
    public String deleteUser(int userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User is not available in database..."));
        this.userRepository.delete(user);
        return "user deleted successfully..";
    }

    @Override
    public UserDto getUserById(int userId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User is not available in database..."));
        return this.toUserDto(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = this.userRepository.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("User is not available in database..."));
        return this.toUserDto(user);
    }

    @Override
    public UserDto getUserByName(String name) {
        User user = this.userRepository.findByName(name)
                .orElseThrow(()-> new ResourceNotFoundException("User is not available in database..."));;
        return this.toUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> allUsers = this.userRepository.findAll();
        List<UserDto> allUserDtos = allUsers.stream().map(user -> this.toUserDto(user)).collect(Collectors.toList());

        return allUserDtos;
    }


    //convert user entity to userDto method
    public UserDto toUserDto(User user){

        UserDto dto= new UserDto();

        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setAbout(user.getAbout());
        dto.setAddress(user.getAddress());
        dto.setGender(user.getGender());
        dto.setPassword(user.getPassword());
        dto.setPhoneNo(user.getPhoneNo());
        dto.setActive(user.isActive());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

    //convert userDto to userEntity method
    public User toUserEntity(UserDto userDto){

        User user=new User();

        user.setUserId(userDto.getUserId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setAddress(userDto.getAddress());
        user.setGender(userDto.getGender());
        user.setPassword(userDto.getPassword());
        user.setPhoneNo(userDto.getPhoneNo());
        user.setActive(userDto.isActive());
        user.setCreatedAt(userDto.getCreatedAt());
        return  user;
    }
}
