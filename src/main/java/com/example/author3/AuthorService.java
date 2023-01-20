package com.example.author3;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepo authorRepo;

    @Autowired
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public List<Author> getAuthors() {
        return authorRepo.findAll();
    }

    public void addNewAuthor( Author author) {

        authorRepo.save(author);
    }

    public void getAuthor(Long authorId){
        boolean exists = authorRepo.existsById(Math.toIntExact(authorId));
        if (!exists) {
            throw new IllegalStateException("author with id"+authorId+"does not exists");

        }
        authorRepo.deleteById(Math.toIntExact(authorId));
    }

//    public void updateAuthor(Long authorId, String name, String language) {
//
//    }

    @Transactional
    public void updateAuthor(Long authorId, String name, String language) {
        Author author = authorRepo.findById(Math.toIntExact(authorId))
                .orElseThrow(() -> new IllegalStateException(
                        "student with id" + authorId + "does not exists"));

        if (name != null && name.length() > 0 &&
                !name.equals(author.getName())) {
            author.setName(name);
        }
        if (language != null && language.length() > 0 &&
                !Objects.equals(author.getLanguage(), language)) {
            Optional<Author> studentOptional = authorRepo.findById(Math.toIntExact(authorId));
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            author.setLanguage(language);
        }
    }
}
