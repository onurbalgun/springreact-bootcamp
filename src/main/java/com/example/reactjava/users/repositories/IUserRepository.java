package com.example.reactjava.users.repositories;

import com.example.reactjava.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,String> {
}
