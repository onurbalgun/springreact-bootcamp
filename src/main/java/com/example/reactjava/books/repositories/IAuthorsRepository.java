package com.example.reactjava.books.repositories;

import com.example.reactjava.books.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorsRepository extends JpaRepository<Authors,String> {
}
