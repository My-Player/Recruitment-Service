package app.service.impl;

import app.dto.UsersDataDto;
import app.model.Club;
import app.model.User;
import app.repository.ClubRepository;
import app.repository.UsersDataRepository;
import app.service.UsersDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service to maintain userdata stuff
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */
@Service
public class UsersDataServiceImpl implements UsersDataService {

    private final UsersDataRepository userDataRepository;
    private final ClubRepository clubRepository;

    @Autowired
    public UsersDataServiceImpl(UsersDataRepository userDataRepository,
                                ClubRepository clubRepository){
        this.userDataRepository = userDataRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public User convertToUsersDataAndSave(UsersDataDto usersDataDto) {
        User user = new User();
        user.setUserAddress(usersDataDto.getUserAddress());
        user.setUserEmail(usersDataDto.getUserEmail());
        user.setUserName(usersDataDto.getUserName());
        user.setUserPhoneNumber(usersDataDto.getUserPhoneNumber());
        user.setUserRating(usersDataDto.getUserRating());
        user.setGender(usersDataDto.getUserGender());
        user.setAge(usersDataDto.getUserAge());
        userDataRepository.save(user);
        return user;
    }

    @Override
    public List<User> getAllUsersData() {
        return userDataRepository.findAll();
    }

    @Override
    public User setUserClub(String userId, String clubId) {
        User user = userDataRepository.getOne(userId);
        Club club = clubRepository.getOne(clubId);

        user.setClub(club);
        userDataRepository.save(user);

        return user;
    }

    @Override
    public List<User> getAllByClub(String clubId) {
        Club club = clubRepository.getOne(clubId);

        return userDataRepository.getAllByClub(club);
    }
}
