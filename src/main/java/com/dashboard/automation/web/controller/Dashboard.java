package com.dashboard.automation.web.controller;

import com.dashboard.automation.modal.domain.Module;
import com.dashboard.automation.modal.domain.RunHistory;
import com.dashboard.automation.modal.domain.Suite;
import com.dashboard.automation.modal.domain.TestCase;
import com.dashboard.automation.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/api/v1/")
@RestController
@RequiredArgsConstructor
public class Dashboard {

    private final ModuleRepository moduleRepository;
    private final TestCaseRepository testCaseRepository;
    private final TestStepsRepository testStepsRepository;
    private final ProductHealthRepository productHealthRepository;
    private final RunHistoryRepository runHistoryRepository;
    private final SuiteRepository suiteRepository;
    private final OverAllExecutionRepository overAllExecutionRepository;

    @CrossOrigin
    @GetMapping("runHistory")
    public ResponseEntity<ArrayList<RunHistory>> getRunHistory() {
        return new ResponseEntity(runHistoryRepository.findAll(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("suites/{runId}")
    public ResponseEntity<ArrayList<Suite>> getSuitesByRunId(@PathVariable @NonNull @Validated Integer runId) {
        return new ResponseEntity(suiteRepository.findAllByRunId(runId), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("modules/{suiteId}")
    public ResponseEntity<ArrayList<Module>> getModulesBySuiteId(@PathVariable @NonNull @Validated Integer suiteId) {
        return new ResponseEntity(moduleRepository.findBySuiteid(suiteId), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("test-cases/{moduleId}")
    public ResponseEntity<ArrayList<TestCase>> getTestCaseByModuleId(@PathVariable @NonNull @Validated Integer moduleId) {
        return new ResponseEntity(testCaseRepository.findTestCaseByModuleId(moduleId), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("test-steps/{testCaseId}")
    public ResponseEntity<ArrayList<TestCase>> getTestStepsByTestCaseId(@PathVariable @NonNull @Validated Integer testCaseId) {
        return new ResponseEntity(testStepsRepository.findTestStepsByTestCaseIdOrderByStepidAsc(testCaseId), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("health")
    public ResponseEntity getHealth()
    {
        return new ResponseEntity(productHealthRepository.getProductHealth(),HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("latestSuites")
    public ResponseEntity<ArrayList<Suite>> getLatestSuites()
    {
        Integer latestRunId = runHistoryRepository.findTop1ByOrderByRunidDesc().getRunid();
        return new ResponseEntity(suiteRepository.findAllByRunId(latestRunId),HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("overAllStatus")
    public ResponseEntity getOverAllExecution()
    {
        return new ResponseEntity(overAllExecutionRepository.findOverAllExecutionData(),HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("latestModules")
    public ResponseEntity<ArrayList<Module>> getLatestExecutionStatusOfModules()
    {
        return new ResponseEntity(moduleRepository.findModulesLatestStatus(),HttpStatus.OK);
    }
}
