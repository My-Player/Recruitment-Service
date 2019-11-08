package app.controller;

import app.dto.ErrorResponse;
import app.dto.RecruitmentDto;
import app.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public RecruitmentController(RecruitmentService recruitmentService){
        this.recruitmentService = recruitmentService;

    }

    @GetMapping(path = "/recruitment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllRecruitment() {
        try {
            return ResponseEntity.ok(recruitmentService.getAllRecruitment());
        }catch(Exception e){
            return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/add-recruitment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postNewRecruitment(@RequestBody RecruitmentDto dto){
        try{
            return new ResponseEntity(recruitmentService.saveRecruitment(dto),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(new ErrorResponse(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }


}
