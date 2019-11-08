package app.controller;

import app.dto.response.ErrorResponse;
import app.service.ClubService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/clubList")
    public ResponseEntity getAllClubBasedOnProvince(@RequestParam String clubCity){
        try{
            return new ResponseEntity(clubService.getAllClubBasedOnClubCity(clubCity),HttpStatus.OK);
        }catch(Exception e){
            log.info("can't fetch data based on club city: {}" + e.getMessage());
            return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
