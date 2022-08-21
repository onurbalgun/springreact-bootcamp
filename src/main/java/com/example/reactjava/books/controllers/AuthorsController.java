package com.example.reactjava.books.controllers;

import com.example.reactjava.books.model.Authors;
import com.example.reactjava.books.repositories.IAuthorsRepository;
import com.example.reactjava.users.controllers.UserController;
import com.example.reactjava.utils.response.R;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@Tag(name = "default")
@CrossOrigin("*")
public class AuthorsController {
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    IAuthorsRepository authorsRepository;

    @Operation(summary = "Find the authors list")
    @GetMapping("")
    @ResponseBody
    public R<List<Authors>> findAuthors()
    {
        List<Authors> authorsList = null;

        try {
            authorsList=authorsRepository.findAll();
        }catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return  new R<List<Authors>>().success().data(authorsList);

    }
    @GetMapping("/{id}")
    @ResponseBody
    public R<Authors> findAuthorsById(@PathVariable String id)
    {
        Authors author =null;

        try {
            author = authorsRepository.findById(id).orElse(new Authors());
        }catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return  new  R<Authors>().success().data(author);
    }
    @Operation(summary = "Update an existing  Author")
    @PutMapping
    public R<Authors> updateAuthor(@RequestBody Authors author)
    {
        try {
            authorsRepository.save(author);
        }catch (Exception e){
            logger.error(e.getMessage());
        }


        return new R<Authors>().success();
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public R<Authors> deleteAuthor(@PathVariable String id)
    {
        try {
            authorsRepository.deleteById(id);
        }catch (Exception e)
        {
            logger.error(e.getMessage());
        }
        return  new  R<Authors>().success();
    }

}
