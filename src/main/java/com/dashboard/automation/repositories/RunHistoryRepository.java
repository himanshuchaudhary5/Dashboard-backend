package com.dashboard.automation.repositories;

import com.dashboard.automation.model.RunHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RunHistoryRepository extends JpaRepository<RunHistory,Integer> {

}
