package com.dashboard.automation.repositories;

import com.dashboard.automation.modal.domain.TestSteps;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestStepsRepository extends JpaRepository<TestSteps, Integer> {

    List<TestSteps> findTestStepsByTestCaseIdOrderByStepidAsc(Integer testCaseId);
}
