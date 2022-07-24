package com.example.Blogger.Services;

import com.example.Blogger.DTO.AuthorDto;
import com.example.Blogger.Entities.Author;
import com.example.Blogger.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Long authorId){
        return authorRepository.findById(authorId).orElseThrow(() -> new IllegalStateException(
                "Auther Id "+ authorId +"doesn't exist"));
    }

    public Iterable<Author> getAuthors(){
        return authorRepository.findAll();
    }

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author author) {
        Author updatedAuthor = getAuthor(id);
        updatedAuthor.setName(author.getName());
        updatedAuthor.setUsername(author.getUsername());
        updatedAuthor.setEmail(author.getEmail());
        updatedAuthor.setAddress(author.getAddress());
        return authorRepository.save(updatedAuthor);
    }

    public Author deleteAuthor(Long id){
        Author author = getAuthor(id);
        authorRepository.delete(author);
        return author;
    }

}
