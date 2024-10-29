package com.javatechie.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import com.javatechie.entity.Users;
import com.javatechie.repository.UserRepository;
import com.javatechie.service.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@InjectMocks
	private UserService service;
	
	@Mock
	private UserRepository repository;
	
	@Test
	public void testFindAllUser() {
		when(repository.findAll()).thenReturn(Stream.of(new Users(102,"full-stack","saikat.sarangi1@mjunction.in","7", "Saikat Sarangi",""))
				.collect(Collectors.toList()));
		assertEquals(1, service.findAllUser().size());
	}
	
	@Test
	void testCancelRegistration() {
		int userId=101;
		service.cancelRegistration(userId);
		
		Mockito.verify(repository).deleteById(userId);
	}
	
	@Test
	void testRegister() {
		
		Users user= new Users(102,"full-stack","saikat.sarangi1@mjunction.in","7", "Saikat Sarangi","");
		when(repository.save(user)).thenReturn(user);
		Users savedUser= service.register(user);
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getName()).isEqualTo("Saikat Sarangi");
	}
	
	@Test
	void testFindUser() {
		
		String email= "saikat.sarangi1@mjunction.in";
		Users user1= new Users(102,"full-stack","saikat.sarangi1@mjunction.in","7", "Saikat Sarangi","");
		Users user2= new Users(102,"full-stack","saikat.sarangi1@mjunction.in","7", "Saikat Sarangi","");
		List<Users> users= new ArrayList<Users>();
		users.add(user1);
		users.add(user2);
		
		
		when(repository.findByEmail(email)).thenReturn(users);
		List<Users> foundUser=service.findUser(email);
		assertThat(foundUser).isNotNull();
		foundUser.stream().allMatch(userObj->userObj.getEmail().equals(email));
		//assertThat(foundUser.getEmail()).isEqualTo(email);
		
		Mockito.verify(repository, Mockito.times(1)).findByEmail(email);
		
	}
	
	
	
	

}
