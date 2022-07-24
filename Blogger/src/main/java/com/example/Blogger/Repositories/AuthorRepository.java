package com.example.Blogger.Repositories;

import com.example.Blogger.Entities.Author;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.cloud.gcp.data.datastore.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends DatastoreRepository<Author, Long> {

    @Query("select * from |com.example.Blogger.Entities.Author| where name = @name")
    List<Author> findByName(@Param("name") String name);

    @Query("select * from |com.example.Blogger.Entities.Author| where email = @email")
    List<Author> findByEmail(String email);

//    List<Author> findByFuelGreaterThan(Integer fuel);

}
