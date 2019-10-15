package app.service.impl;

import app.dto.UsersDataDto;
import app.model.UsersData;
import app.repository.UsersDataRepository;
import app.service.UsersDataService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */
@Service
public class UsersDataServiceImpl implements UsersDataService {

    private final UsersDataRepository userDataRepository;

    @Autowired
    public UsersDataServiceImpl(UsersDataRepository userDataRepository){
        this.userDataRepository = userDataRepository;
    }

    @Override
    public UsersData save(UsersData usersData) {
        userDataRepository.save(usersData);
        return usersData;
    }

    @Override
    public UsersData convertToUsersData(UsersDataDto usersDataDto) {
        UsersData usersData = new UsersData();
        usersData.setUserAddress(usersDataDto.getUserAddress());
        usersData.setUserEmail(usersDataDto.getUserEmail());
        usersData.setUserName(usersDataDto.getUserName());
        usersData.setUserPhoneNumber(usersDataDto.getUserPhoneNumber());
        usersData.setUserRating(usersDataDto.getUserRating());
        usersData.setGender(usersDataDto.getGender());
        usersData.setAge(usersDataDto.getAge());
        return usersData;
    }

}
