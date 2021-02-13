package com.dashboard.automation.modal.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "test_steps")
public class TestSteps {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    int id;
    @Column(name = "testcaseid")
    int testCaseId;
    @Column(name = "stepid")
    int stepid;
    @Column(name = "description")
    String description;
    @Column(name = "screenshot")
    String screenshot;
    @Column(name = "status")
    String status;
}
