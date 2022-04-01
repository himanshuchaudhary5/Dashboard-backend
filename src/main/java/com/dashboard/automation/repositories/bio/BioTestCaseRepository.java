package com.dashboard.automation.repositories.bio;

import com.dashboard.automation.modal.bio.BioTestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

;import java.util.List;

@Repository
public interface BioTestCaseRepository extends JpaRepository<BioTestCase, Integer> {

    List<BioTestCase> findAll();

    BioTestCase getOne(Integer moduleId);

}
