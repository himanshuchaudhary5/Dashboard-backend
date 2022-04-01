package com.dashboard.automation.modal.bio;

import com.dashboard.automation.modal.domain.TestCase;
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
@Table(name = "run_history")
public class BioRunHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Integer id;
    @Column(name = "execution_date_time")
    String executiondatetime;
    @Column(name = "run_by")
    String runby;
    @Column(name = "test_cycle_id")
    String testCycleId;
    @Column(name = "test_cycle_name")
    String testCycleName;
    @Column(name = "environment")
    String environment;
    @Column(name = "pass")
    Integer passed;
    @Column(name = "fail")
    Integer failed;
    @Column(name = "skip")
    Integer skipped;
    @Column(name = "total")
    Integer total;

    @OneToMany(mappedBy = "runId",fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    List<BioTestCase> testCases;
}
