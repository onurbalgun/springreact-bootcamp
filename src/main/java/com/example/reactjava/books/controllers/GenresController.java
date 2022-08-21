package com.example.reactjava.books.controllers;

import com.example.reactjava.books.model.Genres;
import com.example.reactjava.books.repositories.IGenresRepository;
import com.example.reactjava.users.controllers.UserController;
import com.example.reactjava.users.model.User;
import com.example.reactjava.utils.response.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
@Tag(name = "default")
@CrossOrigin("*")
public class GenresController {
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    IGenresRepository genresRepository;

    @GetMapping("")
    @ResponseBody
    public R<List<Genres>> findGenres()
    {
        List<Genres> genresList = null;

        try {
            genresList = genresRepository.findAll();
        }catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return new R<List<Genres>>().success().data(genresList);

    }
    @Operation(summary = "Update an existing  Genre")
    @PutMapping
    public R<Genres> updateGenre(@RequestBody Genres genre)
    {
        try {
            genresRepository.save(genre);
        }catch (Exception e){
            logger.error(e.getMessage());
        }


        return new R<Genres>().success();
    }
    @GetMapping("/{id}")
    @ResponseBody
    public R<Genres> findGenresById(@PathVariable String id)
    {
        Genres genre =null;

        try {
            genre = genresRepository.findById(id).orElse(new Genres());
        }catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return  new  R<Genres>().success().data(genre);
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public R<Genres> deleteGenre(@PathVariable String id)
    {
        try {
            genresRepository.deleteById(id);
        }catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return  new  R<Genres>().success();
    }



}
