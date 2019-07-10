package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.dto.LoginDTO;
import com.hcl.ecommerce.dto.UserDTO;

public interface UserService {

	String registerUser(UserDTO userDTO);

	String loginUser(LoginDTO loginDTO);

	List<UserDTO> getUsers(String role);

}
