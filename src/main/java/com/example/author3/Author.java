package com.example.author3;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Author {

    @Id
    @SequenceGenerator(
            name = "author_id_sequence",
            sequenceName = "author_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_id_sequence"
    )
    private Integer id;
    private String name;
    private Date dateOfBirth;
    private String language;


//    public Author(String name, Integer id, String language, Date dateOfBirth, ArrayList<Object> objects) {
//    }
}
