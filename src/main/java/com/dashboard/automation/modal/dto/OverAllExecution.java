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
public class OverAllExecution {

    @Id
    private Integer id;
    String passed;
    String failed;
    String skipped;
}
