package com.dashboard.automation.modal.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "test_case")
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    int id;
    @Column(name = "moduleid")
    int moduleId;
    @Column(name = "testcaseid")
    String testCaseId;
    @Column(name = "name")
    String name;
    @Column(name = "details")
    String details;
    @Column(name = "status")
    String status;
    @Column(name = "passed")
    Integer passed;
    @Column(name = "failed")
    Integer failed;
    @Column(name = "skipped")
    Integer skipped;
}
