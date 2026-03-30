package com.Banking.pau.service;

import com.Banking.pau.dto.UserDTO;
import com.Banking.pau.dto.UserRequest;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserRequest userRequest);
    UserDTO getUserById(String id);
    List<UserDTO> getAllUsers();
}
