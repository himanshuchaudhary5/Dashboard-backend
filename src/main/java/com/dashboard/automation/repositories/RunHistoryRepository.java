package com.dashboard.automation.repositories;

import com.dashboard.automation.modal.domain.RunHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RunHistoryRepository extends JpaRepository<RunHistory,Integer> {
     List<RunHistory> findAll();

     RunHistory findTop1ByOrderByRunidDesc();
}
