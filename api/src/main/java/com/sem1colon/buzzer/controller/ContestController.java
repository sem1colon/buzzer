package com.sem1colon.buzzer.controller;

import com.sem1colon.buzzer.entity.Contest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Random;



@RestController
@RequestMapping("/api/v1/contest")
public class ContestController {

    private static final Logger logger = LoggerFactory.getLogger(ContestController.class);
    private HashSet<Contest> contests = new HashSet<>();

    @GetMapping("/create")
    public ResponseEntity<?> createContest() {
        try {
            logger.info("createContest(): start");
            Contest contest = new Contest();
            String contestId;
            do {
                contestId = generateContestId();
            } while (!contests.contains(contestId));
            contest.setId(contestId);
            contests.add(contestId);
            logger.debug("contest created - ", contest.getId());
            ResponseEntity response = new ResponseEntity<Contest>(contest, HttpStatus.OK);
            logger.info("createContest(): exit");
            return response;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity<String>("System Error! :(", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    private String generateContestId() {
        return String.format("%04d", new Random().nextInt(10000));
    }

    @PostMapping("/join")
    public ResponseEntity<?> joinContest(Contest contest) {

    }
}
