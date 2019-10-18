package app.controller;

import app.dto.ResponseGeneric;
import app.dto.UsersDataDto;
import app.en.ENUM_STATUS_CODE;
import app.model.User;
import app.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */
@RestController
@RequestMapping(value = "/user-data")
public class UsersDataController {

    private final UsersDataService usersDataService;
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public UsersDataController(UsersDataService usersDataService,
                               HttpServletRequest httpServletRequest){
        this.usersDataService = usersDataService;
        this.httpServletRequest = httpServletRequest;
    }

    @PostMapping(value = "/save")
    public ResponseEntity saveUsersData(@RequestBody UsersDataDto usersData){

        User userData = usersDataService.convertToUsersData(usersData);
        usersDataService.save(userData);

        return ResponseEntity.ok(
                new ResponseGeneric.Builder()
                        .withHttpStatus(HttpStatus.OK.value())
                        .withPath(httpServletRequest.getRequestURI())
                        .withDetail(ENUM_STATUS_CODE.SUCCESS.name())
                        .withTimestamp(new Date())
                        .build());
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllUsersData(){
        List<User> userList = usersDataService.getAllUsersData();
        return ResponseEntity.ok(userList);
    }

}
