package com.codecentric.cvgenerator.model;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codecentric.cvgenerator.api.entities.User;


@Transactional
public interface UserDao extends JpaRepository<User, Long> {

}
