package com.user.userrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.User;

public interface IUserRepository extends JpaRepository<User, String> {

}
