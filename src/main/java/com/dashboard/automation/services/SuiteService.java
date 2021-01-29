package com.dashboard.automation.services;

import com.dashboard.automation.repositories.SuiteRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SuiteService implements SuiteRepository{

    private final EntityManager entityManager;

    @Override
    @Transactional
    public List getSuitesByRunId(Integer runId)
    {
        Session session = entityManager.unwrap(Session.class);
        Query theQuery = session.createQuery("from Suite where runId=:id");
        theQuery.setParameter("id", runId);
        return  theQuery.getResultList();
    }

}
