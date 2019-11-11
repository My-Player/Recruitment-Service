package app.controller;

import app.dto.ApplicationInfoDto;
import app.service.ApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class ApplicationController {

    private final ApplicationInfoService applicationInfoService;

    @Autowired
    public ApplicationController(ApplicationInfoService applicationInfoService) {
        this.applicationInfoService = applicationInfoService;
    }

    //show application list from club (player2 yang mau join)
    @GetMapping("/application")
    public ResponseEntity getAllApplication(@RequestParam String clubId) {
        return ResponseEntity.ok(applicationInfoService.listsAllApplicationInfoByClubId(clubId));
    }

    //apply ke club
    @PostMapping("/apply-club")
    public ResponseEntity applyClub(@RequestBody ApplicationInfoDto applicationInfoDto) {
        return ResponseEntity.ok(applicationInfoService.saveApplicationInfo(applicationInfoDto));
    }

    //club let the applier to join
    @PostMapping("/join-club")
    public ResponseEntity joinClub(@RequestBody ApplicationInfoDto applicationInfoDto) {
        applicationInfoService.doSigningPlayer(applicationInfoDto.getUserId(), applicationInfoDto.getClubId());
        return ResponseEntity.ok(applicationInfoService.findByUserIdAndClubId(applicationInfoDto.getUserId(), applicationInfoDto.getClubId()));
    }
}
