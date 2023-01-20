package com.example.author3;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
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

    @Column
    private String name;

    @Column
    private Date dateOfBirth;

    @Column
    private String language;


    public Author(String name, Integer id, String language, Date dateOfBirth, ArrayList<Object> objects) {
    }
}
