package app.controller;

import app.dto.UsersDataDto;
import app.model.User;
import app.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */
@RestController
@RequestMapping(value = "/v1")
public class UsersDataController {

    private final UsersDataService usersDataService;

    @Autowired
    public UsersDataController(UsersDataService usersDataService){
        this.usersDataService = usersDataService;
    }

    @PostMapping(value = "/user-data/save")
    public ResponseEntity saveUsersData(@RequestBody UsersDataDto usersData){

        User newUser = usersDataService.convertToUsersDataAndSave(usersData);

        return ResponseEntity.ok(newUser);
    }

    @GetMapping(value = "/users-data/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllUsersData(){
        List<User> userList = usersDataService.getAllUsersData();
        return ResponseEntity.ok(userList);
    }

}
