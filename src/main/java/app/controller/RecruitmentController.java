package app.controller;

import app.dto.ErrorResponse;
import app.dto.RecruitmentDto;
import app.service.RecruitmentService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @Autowired
    RecruitmentService recruitmentService;

    @GetMapping(path = "/recruitment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecruitmentDto> getAllRecruitment(){
        try {
            return new ResponseEntity(recruitmentService.getAllRecruitment(), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
