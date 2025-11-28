package com.electronic.Strore.controller;

import com.electronic.Strore.dto.UserDto;
import com.electronic.Strore.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.OutputKeys;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //create
    @PostMapping
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto){
        UserDto user = userService.create(userDto);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> update(
              @Valid @PathVariable ("userId") int userId,
              @RequestBody UserDto userDto
    ){
        UserDto updateUserDto = userService.update(userDto, userId);
        return new ResponseEntity<>(updateUserDto,HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable ("userId") int userId){
        userService.delete(userId);
        return new ResponseEntity<>("User deleted success fully!!",HttpStatus.OK);

    }
    //get all
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser,HttpStatus.OK);
    }
    //get by id

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getById(@PathVariable int  userId){
        UserDto userDto = userService.getById(userId);
        return new ResponseEntity<>(userDto,HttpStatus.OK);

    }

    //get by email
    @GetMapping("/email/{email}")
    public  UserDto getByEmail(@PathVariable String email){
        UserDto userDto = userService.getByEmail(email);
        return userDto;
    }

    //search
    @GetMapping("/search/{Keyword}")
    public  List<UserDto> getByKeyword(@PathVariable String Keyword) {
        List<UserDto> userDto = userService.search(Keyword);
        return userDto;

    }

}
