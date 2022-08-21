package com.example.reactjava.books.repositories;

import com.example.reactjava.books.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBooksRepository extends JpaRepository<Books, String> {
}
