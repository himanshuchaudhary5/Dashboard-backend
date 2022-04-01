package com.dashboard.automation.modal.bio;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "test")
public class BioTestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    int id;
    @Column(name = "run_id")
    int runId;
    @Column(name = "module_name")
    String moduleName;
    @Column(name = "testcase_id")
    String testCaseId;
    @Column(name = "testcase_name")
    String testCaseName;
    @Column(name = "status")
    Integer status;

    @OneToMany(mappedBy = "testId",fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    List<BioTestSteps> testSteps;
}
