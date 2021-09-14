package com.sem1colon.buzzer.controller;

import com.sem1colon.buzzer.entity.Contest;
import com.sem1colon.buzzer.service.ContestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/contest")
public class ContestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContestController.class);

    private ContestService contestService;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @GetMapping("/create")
    public ResponseEntity<?> createContest() {
        try {
            LOGGER.info("createContest() - Start");
            Contest contest = contestService.createContest();
            ResponseEntity response = new ResponseEntity<Contest>(contest, HttpStatus.OK);
            LOGGER.info("createContest() - Exit");
            return response;
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            return new ResponseEntity("System Error! :(", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/join")
    public ResponseEntity<?> joinContest(Contest contest) {
        return null;
    }
}
