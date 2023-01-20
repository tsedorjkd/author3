package com.example.author3;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {

    private final AuthorService authorService;
    private Mapper mapper;

    @Autowired
    public AuthorController(AuthorService authorService, Mapper mapper) {
        this.authorService = authorService;
        this.mapper = mapper;
    }

    @GetMapping
    @ResponseBody
    public List<AuthorDTO> getAuthors() {
        return authorService.getAuthors().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseBody
    public void registerNewAuthor(@RequestBody AuthorCreationDTO authorDTO){
        Author author = mapper.toAuthor(authorDTO);
        authorService.addNewAuthor(author);
    }

    @DeleteMapping("{authorId}")
    public void deleteAuthor(@PathVariable("authorId") Long authorId){
        authorService.getAuthor(authorId);
    }

    @PutMapping(path = "{authorId}")
    public void updateAuthor(
            @PathVariable("authorId") Long authorId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String language){
        authorService.updateAuthor(authorId, name, language);
    }

    @Getter
    @Setter
    public class AuthorDTO{
        private String name;
        private String language;
        private Date dateOfBirth;

        public AuthorDTO(String name) {
        }
    }

    @Getter
    @Setter
    public class AuthorCreationDTO{
        private Integer id;
        private String name;
        private String language;
        private Date dateOfBirth;
    }

    @Component
    class Mapper {
        public AuthorDTO toDto(Author author) {
            String name = author.getName();
            return new AuthorDTO(name);
        }

        public Author toAuthor(AuthorCreationDTO authorDTO) {
            return new Author(authorDTO.getName(),authorDTO.getId(),authorDTO.getLanguage(),authorDTO.getDateOfBirth(), new ArrayList<>());
        }


    }







}
