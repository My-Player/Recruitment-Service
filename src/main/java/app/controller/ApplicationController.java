package app.controller;

import app.dto.ApplicationInfoDto;
import app.service.ApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ApplicationController {

    @Autowired
    ApplicationInfoService applicationInfoService;

    @GetMapping("/application")
    public ResponseEntity<ApplicationInfoDto> getAllApplication(@RequestParam String clubId){
        return new ResponseEntity(applicationInfoService.listsAllApplicationInfo(clubId), HttpStatus.OK);
    }

}
