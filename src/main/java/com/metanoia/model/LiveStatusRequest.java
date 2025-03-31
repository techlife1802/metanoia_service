package com.metanoia.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LiveStatusRequest {

    private String startDate;
    private String endDate;
}
