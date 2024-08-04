package com.javatechie.repository;

import java.util.List;

//import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechie.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	List<Users> findByEmail(String email);

}
