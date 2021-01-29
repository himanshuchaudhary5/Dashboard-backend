package com.dashboard.automation.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuiteRepository {

        public List getSuitesByRunId(Integer runId);
}
