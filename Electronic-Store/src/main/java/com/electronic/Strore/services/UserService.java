package com.electronic.Strore.services;

import com.electronic.Strore.dto.UserDto;

import java.util.List;

public interface UserService {

    //create user
    UserDto create(UserDto userDto);

    //update user
    UserDto update(UserDto userDto,int id);

    //delete user
    void delete(int id);

    //get all users
    List<UserDto> getAllUser(int pageNumber,int pageSize);

    //get single user by id
    UserDto getById(int id);

    //get single user by email
    UserDto getByEmail(String email);

    //search user
   List<UserDto> search(String Keyword);

   //update one data
    UserDto updateSingleData(UserDto userDto,int id);

}
