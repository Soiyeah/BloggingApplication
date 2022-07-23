package com.example.Blogger.Controllers;

import com.example.Blogger.DTO.AuthorDto;
import com.example.Blogger.Entities.Author;
import com.example.Blogger.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/author")
@CrossOrigin("*")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    // Get list of all authors
    @GetMapping
    public ResponseEntity<List<AuthorDto>> getCustomers(){
        List<Author> authors = new ArrayList<>();
        authorService.getAuthors().iterator().forEachRemaining(authors::add);
        List<AuthorDto> customersDto = authors.stream().map(AuthorDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(customersDto, HttpStatus.OK);
    }


}
