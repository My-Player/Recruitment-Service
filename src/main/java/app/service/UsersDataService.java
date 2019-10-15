package app.service;

import app.dto.UsersDataDto;
import app.model.UsersData;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */
public interface UsersDataService {

    UsersData save(UsersData usersData);
    UsersData convertToUsersData(UsersDataDto usersDataDto);
}
