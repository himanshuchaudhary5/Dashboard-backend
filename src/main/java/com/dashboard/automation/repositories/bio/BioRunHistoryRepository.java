package com.dashboard.automation.repositories.bio;

import com.dashboard.automation.modal.bio.BioRunHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BioRunHistoryRepository extends JpaRepository<BioRunHistory, Integer> {
    List<BioRunHistory> findAll();

    BioRunHistory saveAndFlush(BioRunHistory bioRunHistory);

}
