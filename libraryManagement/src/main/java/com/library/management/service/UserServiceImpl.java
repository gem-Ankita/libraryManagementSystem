package com.library.management.service;

import com.library.management.entity.User;
import com.library.management.exceptions.ConfigDataResourceNotFoundException;
import com.library.management.payloads.UserDto;
import com.library.management.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDt) {
        User user = this.dtToUser(userDt);
        User savedUSer = this.userRepository.save(user);
        return this.userToDt(savedUSer);
    }

    @Override
    public UserDto updateUser(UserDto userDt, Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ConfigDataResourceNotFoundException("User", "id", userId));
        user.setName(userDt.getName());
        user.setEmail(userDt.getEmail());

        User updatedUser = this.userRepository.save(user);
        UserDto userDt1 = this.userToDt(updatedUser);
        return userDt1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ConfigDataResourceNotFoundException("User", "Id", userId));
        return this.userToDt(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDts = users.stream().map(user -> this.userToDt(user)).collect(Collectors.toList());
        return userDts;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ConfigDataResourceNotFoundException("User", "Id", userId));
        this.userRepository.delete(user);
    }

    private User dtToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }

    private UserDto userToDt(User user) {
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
