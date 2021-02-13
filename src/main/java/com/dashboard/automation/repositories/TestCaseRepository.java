package com.dashboard.automation.repositories;

import com.dashboard.automation.modal.domain.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestCaseRepository extends JpaRepository<TestCase,Integer> {

    List<TestCase> findTestCaseByModuleId(Integer moduleId);

}
