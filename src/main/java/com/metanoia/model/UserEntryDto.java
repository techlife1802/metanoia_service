package com.metanoia.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEntryDto {
    
    private String userName;
    private String accessLevel;
    private List<String> fields;
    private String password;

}
