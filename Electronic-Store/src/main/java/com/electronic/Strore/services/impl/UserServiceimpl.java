package com.electronic.Strore.services.impl;

import com.electronic.Strore.dto.UserDto;
import com.electronic.Strore.entities.User;
import com.electronic.Strore.exception.ResourceNotFoundException;
import com.electronic.Strore.repositories.UserRepository;
import com.electronic.Strore.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public UserDto create(UserDto userDto) {
        //dto -> entity
        User user=dtoToEntity(userDto);
        User savedUser = userRepository.save(user);
        //entity -> dto
        UserDto newDto=entityToDto(savedUser);
        return newDto;
    }



    @Override
    public UserDto update(UserDto userDto, int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found with this id"));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setImageName(userDto.getImageName());
        user.setGender(userDto.getGender());
        user.setPassword(userDto.getPassword());
        User updatedUser = userRepository.save(user);
        UserDto updatedUserDto=entityToDto(user);
        return updatedUserDto;

    }

    @Override
    public void delete(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id not found"));
        userRepository.delete(user);

    }

    @Override
    public List<UserDto> getAllUser(int pageNumber,int pageSize) {
        List<User> users=userRepository.findAll();
        List<UserDto> dtoList=users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public UserDto getById(int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id not found"));
        return entityToDto(user);
    }

    @Override
    public UserDto getByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("User not found with this email"));
        return entityToDto(user);

    }

    @Override
    public List<UserDto> search(String keyword) {
        List<User> users=userRepository.findByNameContaining(keyword);
        List<UserDto> dtoList=users.stream().map(user -> entityToDto(user)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public UserDto updateSingleData(UserDto userDto, int id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id"));

        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        User updatedData = userRepository.save(user);
        UserDto userDto1 = entityToDto(updatedData);
        return userDto1;
    }

    private UserDto entityToDto(User savedUser) {
//        UserDto userDto = UserDto.builder()
//                .userId(savedUser.getUserId())
//                .password(savedUser.getPassword())
//                .email(savedUser.getEmail())
//                .name(savedUser.getName())
//                .gender(savedUser.getGender())
//                .imageName(savedUser.getImageName()).build();
        return mapper.map(savedUser, UserDto.class);
    }

    private User dtoToEntity(UserDto userDto) {
//        User user=User.builder()
//                .userId(userDto.getUserId())
//                .name(userDto.getName())
//                .email(userDto.getEmail())
//                .gender(userDto.getGender())
//                .imageName(userDto.getImageName())
//                .password(userDto.getPassword()).build();

        return mapper.map(userDto,User.class);
    }
}
