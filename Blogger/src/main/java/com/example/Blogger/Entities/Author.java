package com.example.Blogger.Entities;

import com.example.Blogger.DTO.AuthorDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    private Long id;
    private String name;
    private String username;
    private String email;
    private String address;

    public static Author from(AuthorDto authorDto){
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setUsername(authorDto.getUsername());
        author.setEmail(authorDto.getEmail());
        author.setAddress(authorDto.getAddress());
        return author;
    }


}
