	package com.mobile.demo;
	
	
	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.mockito.Mockito.when;
	
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;
	
	import org.junit.jupiter.api.Order;
	import org.junit.jupiter.api.Test;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.springframework.boot.test.context.SpringBootTest;
	
	import com.mobile.demo.entity.User;
	import com.mobile.demo.repository.UserRepository;
	import com.mobile.demo.service.UserService;
	
	@SpringBootTest(classes = {UserServiceMockitoTests.class})
	public class UserServiceMockitoTests {
		
		@Mock
		UserRepository userRepository;
		
		@InjectMocks
		UserService userService;
		//aaa concept arrange assert   //elk stack  kivana,spunk....
		public List<User> myusers;
		
		@Test
		@Order(1)
		public void test_getAllUsers()
		{
			List<User> myusers = new ArrayList<User>();
			myusers.add(new User(Long.valueOf(1),"sunny123","sunny@123","sunny@gmail.com","9154330356","vijayawada"));
			myusers.add(new User(Long.valueOf(2),"sharu123","sharu@123","smh@gmail.com","7036729644","Gudivada"));
			
			when(userRepository.findAll()).thenReturn(myusers);
			assertEquals(2, userService.getAllUsers().size());
			
		}
		
		@Test
		@Order(2)
		//below code working one...
//		 public void test_getUserById() {
//	        User user = new User(Long.valueOf(1), "sunny123", "sunny@123", "sunny@gmail.com", "9154330356", "vijayawada");
//	
//	        Long userid = 1L;
//	        when(userRepository.findById(userid)).thenReturn(Optional.of(user));
//	        assertEquals(userid, userService.getUserById(userid).getUserid());
//	    }
		public void test_getUserById() {
			List<User> myusers = new ArrayList<User>();
			myusers.add(new User(Long.valueOf(1),"sunny123","sunny@123","sunny@gmail.com","9154330356","vijayawada"));
			myusers.add(new User(Long.valueOf(2),"sharu123","sharu@123","smh@gmail.com","7036729644","Gudivada"));
			 when(userRepository.findById(1L)).thenReturn(Optional.of(myusers.get(0)));
		        when(userRepository.findById(2L)).thenReturn(Optional.of(myusers.get(1)));

		        // Test the service method
		        assertEquals(Long.valueOf(1), userService.getUserById(1L).getUserid());
		        assertEquals(Long.valueOf(2), userService.getUserById(2L).getUserid());
		}
		
		@Test
		@Order(3)
		public void test_saveUser() {
			User user = new User(Long.valueOf(3),"dilip123","dilip@123","dilip@gmail.com","9738397937","chennai");
			when(userRepository.save(user)).thenReturn(user);
			assertEquals(user,userService.saveUser(user));
		}
	}
