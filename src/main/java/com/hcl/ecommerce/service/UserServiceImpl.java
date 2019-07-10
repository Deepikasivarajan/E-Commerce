package com.hcl.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.LoginDTO;
import com.hcl.ecommerce.dto.UserDTO;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	public String registerUser(UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		userRepository.save(user);
		LOGGER.info("registered");
		return "user registered";
	}

	public String loginUser(LoginDTO loginDTO) {
		userRepository.findByUserNameAndPassword(loginDTO.getUserName(), loginDTO.getPassword());
		LOGGER.info("logged in");
		return "login success";
	}

	@Override
	public List<UserDTO> getUsers(String role) {
		UserDTO userDTO = new UserDTO();
		List<UserDTO> listUserDTO = new ArrayList<UserDTO>();
		List<User> user = userRepository.findByRole(role);
		for (User user2 : user) {
			userDTO.setAge(user2.getAge());
			userDTO.setDateOfBirth(user2.getDateOfBirth());
			userDTO.setEmail(user2.getEmail());
			userDTO.setPhoneNumber(user2.getPhoneNumber());
			userDTO.setSex(user2.getSex());
			userDTO.setUserName(user2.getUserName());
			listUserDTO.add(userDTO);
		}
		return listUserDTO;
	}

}
