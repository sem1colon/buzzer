package com.sem1colon.buzzer.contest;

import com.sem1colon.buzzer.contestant.Contestant;
import com.sem1colon.buzzer.contestant.ContestantAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/contest")
public class ContestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContestController.class);

    private ContestService contestService;

    ResponseEntity<?> responseEntity;

    @Autowired
    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createContest(@RequestBody Contest contest) {
        try {
            LOGGER.info("createContest() - Start");
            Contest createdContest = contestService.createContest(contest);
            responseEntity = new ResponseEntity<Contest>(createdContest, HttpStatus.OK);
            LOGGER.info("createContest() - Exit");
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            responseEntity = new ResponseEntity<String>("System Error! :(", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/join/{contestId}")
    public ResponseEntity<?> joinContest(@PathVariable(value = "contestId") final String contestId, @RequestBody final Contestant contestant) {
        try {
            LOGGER.info("joinContest() - Start");
            Contest contest = contestService.joinContest(contestId, contestant);
            responseEntity = new ResponseEntity<Contest>(contest, HttpStatus.OK);
            LOGGER.info("joinContest() - Exit");
        } catch (InvalidContestException invalidContestException){
            responseEntity = new ResponseEntity<String>(invalidContestException.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (ContestantAlreadyExistsException contestantAlreadyExistsException){
            responseEntity = new ResponseEntity<>(contestantAlreadyExistsException.getMessage(), HttpStatus.CONFLICT);
        }
        catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            responseEntity = new ResponseEntity<String>("System Error! :(", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
