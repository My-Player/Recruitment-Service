package app.controller;

import app.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */
@RestController
@RequestMapping(value = "/v1")
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @Autowired
    public RecruitmentController(RecruitmentService recruitmentService) {
        this.recruitmentService = recruitmentService;
    }

    @GetMapping(path = "/recruitment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllRecruitment() {
        return ResponseEntity.ok(recruitmentService.getAllRecruitment());
    }

    //get recruitment by club
    @GetMapping("/get-recruitment-by-club")
    public ResponseEntity getRecruitment(@RequestParam String clubId){
        return ResponseEntity.ok(recruitmentService.getAllByClub(clubId));
    }
}
