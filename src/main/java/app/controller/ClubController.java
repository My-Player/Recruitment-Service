package app.controller;

import app.dto.ClubDto;
import app.dto.response.ErrorResponse;
import app.model.Club;
import app.service.ClubService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ClubController {

    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    private static final Logger log = Logger.getLogger(ClubController.class.getName());

    @GetMapping("/club-list")
    public ResponseEntity<?> getAllClub() {
        try {
            return ResponseEntity.ok(clubService.getAllClub());
        } catch (Exception e) {
            log.info("failed to fetch all club data: {}" + e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
  clubName;
  clubAddress;
  clubCity;
  logo;
     */
    @PostMapping("/save-club")
    public ResponseEntity saveClub(@RequestBody ClubDto clubDto) {
        try {
            Club newClub = clubService.convertToClubAndSave(clubDto);
            return ResponseEntity.ok(newClub);
        }catch (Exception e){
            log.info("failed to save club data: {}" + e.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
