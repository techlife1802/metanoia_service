package com.metanoia.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ShipmentDetailsUserRequest {

    private String user;
    private List<String> columns;
    private String startDate;
    private String endDate;
}
