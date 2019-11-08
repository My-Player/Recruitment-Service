package app.controller;

import app.dto.ErrorResponse;
import app.service.ApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ApplicationController {

    @Autowired
    ApplicationInfoService applicationInfoService;

    @GetMapping("/application")
    public ResponseEntity getAllApplication(@RequestParam String clubId) {
        try {
            return new ResponseEntity(applicationInfoService.listsAllApplicationInfo(clubId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(new ErrorResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/application-success")
    public ResponseEntity getApplicationSuccess(@RequestParam String clubId, @RequestParam String userId) {
        try{
        return new ResponseEntity(applicationInfoService.applicationSuccess(clubId, userId), HttpStatus.OK);
    }catch(Exception e){
        return new ResponseEntity(new ErrorResponse(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/application-rejected")
    public ResponseEntity getApplicationRejected(@RequestParam String clubId, @RequestParam String userId){
        try{
            return new ResponseEntity(applicationInfoService.applicationRejected(clubId,userId),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(new ErrorResponse(e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
