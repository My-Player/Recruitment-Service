package app.service;

import app.dto.UsersDataDto;
import app.model.User;

import java.util.List;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */
public interface UsersDataService {

    User save(User user);
    User convertToUsersData(UsersDataDto usersDataDto);
    List<User> getAllUsersData();
}
