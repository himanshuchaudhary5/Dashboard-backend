package com.dashboard.automation.web.controller.bio;

import com.dashboard.automation.modal.bio.BioRunHistory;
import com.dashboard.automation.repositories.bio.BioRunHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("/api/v2/")
@RestController
@RequiredArgsConstructor
public class BasicController {

    private final BioRunHistoryRepository bioRunHistoryRepository;

    @CrossOrigin
    @GetMapping("runHistory")
    public ResponseEntity<ArrayList<BioRunHistory>> runHistory() {
        return new ResponseEntity(bioRunHistoryRepository.findAll(), HttpStatus.OK);
    }
}
