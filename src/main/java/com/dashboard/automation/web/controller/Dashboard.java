package com.dashboard.automation.web.controller;

import com.dashboard.automation.model.RunHistory;
import com.dashboard.automation.model.Suite;
import com.dashboard.automation.services.RunHistoryService;
import com.dashboard.automation.services.SuiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("/api/v1/")
@RestController
@RequiredArgsConstructor
public class Dashboard {

    private final RunHistoryService runHistoryService;
    private final SuiteService suiteService;

    @GetMapping("runHistory")
    public ResponseEntity<ArrayList<RunHistory>> getRunHistory() {
        return new ResponseEntity(runHistoryService.getRunHistory(), HttpStatus.OK);
    }

    @GetMapping("suites/{runId}")
    public ResponseEntity<ArrayList<Suite>> getSuitesByRunId(@PathVariable @NonNull @Validated Integer runId) {
        return new ResponseEntity(suiteService.getSuitesByRunId(runId), HttpStatus.OK);
    }

}
