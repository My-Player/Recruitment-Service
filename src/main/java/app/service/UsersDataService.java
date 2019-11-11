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
    User convertToUsersDataAndSave(UsersDataDto usersDataDto);
    List<User> getAllUsersData();

    User setUserClub(String user, String club);

    List<User> getAllByClub(String clubId);
}
