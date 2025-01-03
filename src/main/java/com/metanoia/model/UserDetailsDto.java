package com.metanoia.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDetailsDto {

    private String userName;
    private List<String> fields;
    private String accessLevel;
    private String password;
}
