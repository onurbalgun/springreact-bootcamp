package com.example.reactjava.books.repositories;

import com.example.reactjava.books.model.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenresRepository extends JpaRepository<Genres, String> {
}
