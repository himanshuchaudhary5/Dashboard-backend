package com.dashboard.automation.repositories;

import com.dashboard.automation.modal.dto.ProductHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductHealthRepository extends JpaRepository<ProductHealth,String> , JpaSpecificationExecutor<ProductHealth> {
    @Query(nativeQuery = true,value = "Select ROW_NUMBER() over() as id, runid as run_id, suite_name,(passed*100)/(passed+failed+skipped) as pass_percentage  from suite order by runid asc")
    List<ProductHealth> getProductHealth();
}
