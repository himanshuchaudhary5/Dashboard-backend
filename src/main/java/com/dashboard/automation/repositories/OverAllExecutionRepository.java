package com.dashboard.automation.repositories;

import com.dashboard.automation.modal.dto.OverAllExecution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface OverAllExecutionRepository extends JpaRepository<OverAllExecution,Integer>, JpaSpecificationExecutor<OverAllExecution> {

    @Query(nativeQuery = true,value = "Select ROW_NUMBER() over() as id, passed, failed, skipped from (\n" +
            "(Select count(*) as passed from automation_dashboard.test_case where failed = 0 and skipped = 0 and passed > 0)  as passcount,\n" +
            "(Select count(*) as failed from automation_dashboard.test_case where failed > 0 )  as failcount,\n" +
            "(Select count(*) as skipped from automation_dashboard.test_case where failed = 0 and passed = 0 and skipped > 0 )  as skipcount\n" +
            ");")
    OverAllExecution findOverAllExecutionData();
}
