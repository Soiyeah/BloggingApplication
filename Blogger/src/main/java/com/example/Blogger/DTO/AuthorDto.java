package com.example.Blogger.DTO;

import com.example.Blogger.Entities.Author;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class AuthorDto {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String address;

    public static AuthorDto from(Author author){
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(author.getId());
        authorDto.setName(author.getName());
        authorDto.setUsername(author.getUsername());
        authorDto.setEmail(author.getEmail());
        authorDto.setAddress(author.getAddress());
        return authorDto;
    }


}
