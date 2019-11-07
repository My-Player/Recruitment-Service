package app.controller;

import app.service.ClubService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ClubController {

    @Autowired
    ClubService clubService;

    public static final Logger log = Logger.getLogger(ClubController.class.getName());

    @GetMapping("/club-list")
    public ResponseEntity getAllClub() {
        try {
            return new ResponseEntity(clubService.getAllClub(), HttpStatus.OK);
        }catch (Exception e){
            log.info("failed to fetch all club data: {}" + e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }


}
