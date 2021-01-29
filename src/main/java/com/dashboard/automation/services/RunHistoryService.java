package com.dashboard.automation.services;

import com.dashboard.automation.model.RunHistory;
import com.dashboard.automation.repositories.RunHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RunHistoryService {

    private final RunHistoryRepository runHistoryRepository;

    @Transactional
    public List<RunHistory> getRunHistory()
    {
        return runHistoryRepository.findAll();
    }


}
