package com.eng.marko.manojlovic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eng.marko.manojlovic.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
