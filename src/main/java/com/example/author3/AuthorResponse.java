package com.example.author3;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {
    private Integer id;
    private String name;
    private Date dateOfBirth;
    private String language;
}
