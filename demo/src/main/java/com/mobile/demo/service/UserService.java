package com.mobile.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mobile.demo.Exception.UserNotFoundException;
import com.mobile.demo.entity.User;
import com.mobile.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	 public User getUserById(Long userid) {
	        return userRepository.findById(userid)
	            .orElseThrow(() -> new UserNotFoundException("User with ID " + userid + " not found"));
	    }
//	    public User updateUser(Long userid, User user) {
//	        Optional<User> existingUserOpt = userRepository.findById(userid);
//	        if (existingUserOpt.isPresent()) {
//	            User existingUser = existingUserOpt.get();
//	            existingUser.setUsername(user.getUsername());
//	            existingUser.setPassword(user.getPassword());
//	            existingUser.setEmail(user.getEmail());
//	            existingUser.setPhoneNumber(user.getPhoneNumber());
//	            existingUser.setAddress(user.getAddress());
//	            return userRepository.save(existingUser);
//	        } else {
//	            throw new UserNotFoundException("User with ID " + userid + " not found for update");
//	        }
//	    }


		public User updateUser(Long userid, User user) {
			if (!userRepository.existsById(userid)) {
				throw new UserNotFoundException("User with ID " + userid + " not found for update");
			}
			user.setUserid(userid);
			return userRepository.save(user);
		}
//	public boolean deleteUserById(Long userid) {
//		User eu = userRepository.findById(userid).orElse(null);
//		if(eu != null) {
//			userRepository.delete(eu);
//			return true;
//		}
//		return false;
//	}
	 public boolean deleteUserById(Long userid) {
	        if (!userRepository.existsById(userid)) {
	        	throw new UserNotFoundException("User with ID " + userid + " not found for deletion");
	        }
	        userRepository.deleteById(userid);
	        return true;
	    }
}
