package com.example.author3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AuthorRepo extends JpaRepository<Author, Integer> {

}
