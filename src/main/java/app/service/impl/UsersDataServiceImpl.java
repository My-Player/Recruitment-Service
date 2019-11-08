package app.service.impl;

import app.dto.UsersDataDto;
import app.model.User;
import app.repository.UsersDataRepository;
import app.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User save(User user) {
        userDataRepository.save(user);
        return user;
    }

    @Override
    public User convertToUsersData(UsersDataDto usersDataDto) {
        User user = new User();
        user.setUserAddress(usersDataDto.getUserAddress());
        user.setUserEmail(usersDataDto.getUserEmail());
        user.setUserName(usersDataDto.getUserName());
        user.setUserPhoneNumber(usersDataDto.getUserPhoneNumber());
        user.setUserRating(usersDataDto.getUserRating());
        user.setGender(usersDataDto.getGender());
        user.setAge(usersDataDto.getAge());
        return user;
    }


    @Override
    public List<User> getAllUsersData() {
        return userDataRepository.findAll();
    }

}
