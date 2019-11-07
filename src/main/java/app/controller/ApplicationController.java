package app.controller;

import app.dto.ApplicationInfoDto;
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
    public ResponseEntity getAllApplication(@RequestParam String clubId){
        return new ResponseEntity(applicationInfoService.listsAllApplicationInfo(clubId), HttpStatus.OK);
    }

    @PutMapping("/application-success")
    public ResponseEntity getApplicationSuccess(@RequestParam String clubId,@RequestParam String userId){
        return new ResponseEntity(applicationInfoService.applicationSuccess(clubId,userId),HttpStatus.OK);
    }


}
