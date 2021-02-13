package com.dashboard.automation.repositories;

import com.dashboard.automation.modal.domain.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {

    List<Module> findBySuiteid(Integer suiteId);

    @Query(nativeQuery = true, value = "SELECT id, suiteid,name,details,status,duration,passed,failed,skipped\n" +
            "FROM (SELECT id, suiteid,name,details,status,duration,passed,failed,skipped, \n" +
            "MAX(id) OVER (PARTITION BY name) as maxid FROM module) x WHERE id = maxid")
    List<Module> findModulesLatestStatus();

}
