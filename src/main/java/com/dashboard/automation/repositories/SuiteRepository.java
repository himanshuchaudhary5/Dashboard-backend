package com.dashboard.automation.repositories;

import com.dashboard.automation.modal.domain.Suite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuiteRepository extends JpaRepository<Suite,Integer> {

         List<Suite> findAllByRunId(Integer runId);

}
