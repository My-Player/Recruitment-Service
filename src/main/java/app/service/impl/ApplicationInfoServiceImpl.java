package app.service.impl;

import app.dto.ApplicationInfoDto;
import app.model.Club;
import app.model.ApplicationInfo;
import app.model.User;
import app.repository.ClubRepository;
import app.repository.ApplicationInfoRepository;
import app.repository.UsersDataRepository;
import app.service.ApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static app.constant.StatusConstant.*;

@Service
public class ApplicationInfoServiceImpl implements ApplicationInfoService {

    private final UsersDataRepository usersDataRepository;
    private final ApplicationInfoRepository appInfoRepository;
    private final ClubRepository clubRepository;

    @Autowired
    public ApplicationInfoServiceImpl(UsersDataRepository usersDataRepository,
                                      ApplicationInfoRepository appInfoRepository,
                                      ClubRepository clubRepository) {
        this.usersDataRepository = usersDataRepository;
        this.appInfoRepository = appInfoRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public ApplicationInfo saveApplicationInfo(ApplicationInfoDto dto) {
        User user = usersDataRepository.getOne(dto.getUserId());
        ApplicationInfo rec = new ApplicationInfo();

        rec.setRecruitmentStatus(PROCESSED.getMessage());
        rec.setUser(user);
        rec.setCreatedDate(new Date());
        rec.setClub(clubRepository.getOne(dto.getClubId()));
        appInfoRepository.save(rec);

        return rec;

    }

    //ini buat list all player who apply in club
    @Override
    public List<ApplicationInfo> listsAllApplicationInfoByClubId(String clubId) {

        Club club = clubRepository.findOne(clubId);

        return appInfoRepository.findAllByClub(club);
    }

    @Override
    public void doSigningPlayer(String userId, String clubId) {
        User user = usersDataRepository.getOne(userId);
        Club club = clubRepository.getOne(clubId);
        ApplicationInfo applicationInfo = this.findByUserIdAndClubId(userId, clubId);

        user.setClub(club);
        club.setClubMembers(club.getClubMembers() + 1);
        applicationInfo.setRecruitmentStatus(APPROVED.getMessage());
        applicationInfo.setJoinedDate(new Date());
    }

    @Override
    public void doRejectPlayer(String applicationId) {
        ApplicationInfo applicationInfo = appInfoRepository.getOne(applicationId);
        applicationInfo.setRecruitmentStatus(REJECTED.getMessage());
    }

    @Override
    public ApplicationInfo findByUserIdAndClubId(String userId, String clubId) {
        return appInfoRepository.findByUserAndClub(usersDataRepository.getOne(userId), clubRepository.getOne(clubId));
    }

}