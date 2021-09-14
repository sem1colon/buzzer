package com.sem1colon.buzzer.contest;

import com.sem1colon.buzzer.contestant.Contestant;
import com.sem1colon.buzzer.contestant.ContestantAlreadyExistsException;
import com.sem1colon.buzzer.contestant.ContestantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class ContestService {

    private ContestRepository contestRepository;
    private ContestantRepository contestantRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ContestService.class);

    @Autowired
    public ContestService(ContestRepository contestRepository, ContestantRepository contestantRepository) {
        this.contestRepository = contestRepository;
        this.contestantRepository = contestantRepository;
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

    public Contest joinContest(String contestId, Contestant contestant) throws InvalidContestException, ContestantAlreadyExistsException {
        LOGGER.info("joinContest() - Start");
        Optional<Contest> contest = contestRepository.findById(contestId);
        if (contest.isPresent()) {
            boolean isContestantExisting = contestantRepository.existsById(contestant.getUsername());
            if (isContestantExisting) {
                throw new ContestantAlreadyExistsException(contestant.getUsername()+" already exists!");
            } else {
                contest.get().getContestants().add(contestant);
                contestRepository.save(contest.get());
            }
        } else {
            throw new InvalidContestException("No contest was found with that code!");
        }
        LOGGER.info("joinContest() - End");
        return contest.get();
    }
}
