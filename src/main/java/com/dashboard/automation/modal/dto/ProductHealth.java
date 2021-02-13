package com.dashboard.automation.modal.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductHealth {

    @Id
    private Integer id;
    String runId;
    String suite_name;
    String pass_percentage;

}
