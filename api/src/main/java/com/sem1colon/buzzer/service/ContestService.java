package com.sem1colon.buzzer.service;

import com.sem1colon.buzzer.entity.Contest;
import com.sem1colon.buzzer.repository.ContestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ContestService {

    private ContestRepository contestRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ContestService.class);

    @Autowired
    public ContestService(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    public Contest createContest() {
        LOGGER.info("createContest() - Start");
        Contest contest = new Contest();
        String contestId;
        do {
            contestId = generateContestId();
        } while (contestRepository.existsById(contestId));
        contest.setId(contestId);
        contest.setHost("default");
        LOGGER.debug("Contest {} created!", contest.getId());
        contestRepository.save(contest);
        LOGGER.info("createContest() - Exit");
        return contest;
    }


    private String generateContestId() {
        String contestId = String.format("%04d", new Random().nextInt(10000));
        return contestId;
    }

}
