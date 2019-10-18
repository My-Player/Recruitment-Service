package app.service.impl;

import app.dto.ApplicationInfoDto;
import app.model.Club;
import app.model.Recruitment;
import app.model.ApplicationInfo;
import app.model.User;
import app.repository.ClubRepository;
import app.repository.ApplicationInfoRepository;
import app.repository.RecruitmentRepository;
import app.repository.UsersDataRepository;
import app.service.ApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ApplicationInfoServiceImpl implements ApplicationInfoService {

    @Autowired
    private UsersDataRepository usersDataRepository;

    @Autowired
    private RecruitmentRepository recruitmentRepository;

    @Autowired
    private ApplicationInfoRepository appInfoRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public void saveApplicationInfo(ApplicationInfoDto dto) {
        User user = usersDataRepository.getOne(dto.getUserId());
        Recruitment recruitment = recruitmentRepository.getOne(dto.getRecruitmentId());
        ApplicationInfo rec = new ApplicationInfo();

        rec.setRecruitmentStatus("Processed");
        rec.setUser(user);
        rec.setRecruitment(recruitment);
        appInfoRepository.save(rec);
    }

    @Override
    public List<ApplicationInfoDto> listsAllRecruitmentInfo(String clubId) {
        List<ApplicationInfoDto> list = new ArrayList<>();
        List<ApplicationInfo> applicationInfos = appInfoRepository.findApplicationInfoByClubId(clubId);
        Club club = clubRepository.findOne(clubId);

        if (club != null) {
            for (ApplicationInfo rec : applicationInfos) {
                ApplicationInfoDto dto = new ApplicationInfoDto();
                dto.setApplicationInfoId(rec.getApplicationInfoId());
                dto.setUserId(rec.getUser().getUserId());
                dto.setUserName(rec.getUser().getUserName());
                dto.setRecruitmentStatus("processed");
                list.add(dto);
            }
        }
        return list;
    }
}