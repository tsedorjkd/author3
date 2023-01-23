package com.example.author3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/author")
//@RequiredArgsConstructor
public class AuthorController {

    @Autowired
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createAuthor(@RequestBody AuthorRequest authorRequest) {
        authorService.createAuthor(authorRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorResponse> getAllAuthors(){
        return authorService.getAllAuthors();
    }
}
//    private Mapper mapper;
//
//    @Autowired
//    public AuthorController(AuthorService authorService, Mapper mapper) {
//        this.authorService = authorService;
//        this.mapper = mapper;
//    }
//
//    @GetMapping
//    @ResponseBody
//    public List<AuthorDTO> getAuthors() {
//        return authorService.getAuthors().stream().map(mapper::toDto).collect(Collectors.toList());
//    }
//
//    @PostMapping
//    @ResponseBody
//    public void registerNewAuthor(@RequestBody AuthorCreationDTO authorDTO){
//        Author author = mapper.toAuthor(authorDTO);
//        authorService.addNewAuthor(author);
//    }
//
//    @DeleteMapping("{authorId}")
//    public void deleteAuthor(@PathVariable("authorId") Long authorId){
//        authorService.getAuthor(authorId);
//    }
//
//    @PutMapping(path = "{authorId}")
//    public void updateAuthor(
//            @PathVariable("authorId") Long authorId,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String language){
//        authorService.updateAuthor(authorId, name, language);
//    }

//    @Getter
//    @Setter
//    public class AuthorDTO{
//        private String name;
//        private String language;
//        private Date dateOfBirth;
//
//        public AuthorDTO(String name) {
//        }
//    }
//
//    @Getter
//    @Setter
//    public class AuthorCreationDTO{
//        private Integer id;
//        private String name;
//        private String language;
//        private Date dateOfBirth;
//    }

//    @Component
//    class Mapper {
//        public AuthorDTO toDto(Author author) {
//            String name = author.getName();
//            return new AuthorDTO(name);
//        }
//
//        public Author toAuthor(AuthorCreationDTO authorDTO) {
//            return new Author(authorDTO.getName(),authorDTO.getId(),authorDTO.getLanguage(),authorDTO.getDateOfBirth(), new ArrayList<>());
//        }
//
//
//    }








