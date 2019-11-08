package app.service.impl;

import app.dto.ApplicationInfoDto;
import app.dto.ApplicationInfoResponse;
import app.model.Club;
import app.model.Recruitment;
import app.model.ApplicationInfo;
import app.model.User;
import app.repository.ClubRepository;
import app.repository.ApplicationInfoRepository;
import app.repository.RecruitmentRepository;
import app.repository.UsersDataRepository;
import app.service.ApplicationInfoService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static app.constant.StatusConstant.*;

@Service
public class ApplicationInfoServiceImpl implements ApplicationInfoService {

    private final UsersDataRepository usersDataRepository;
    private final RecruitmentRepository recruitmentRepository;
    private final ApplicationInfoRepository appInfoRepository;
    private final ClubRepository clubRepository;

    @Autowired
    public ApplicationInfoServiceImpl(UsersDataRepository usersDataRepository,
                                      RecruitmentRepository recruitmentRepository,
                                      ApplicationInfoRepository appInfoRepository,
                                      ClubRepository clubRepository) {
        this.usersDataRepository = usersDataRepository;
        this.recruitmentRepository = recruitmentRepository;
        this.appInfoRepository = appInfoRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void saveApplicationInfo(ApplicationInfoDto dto) {
        User user = usersDataRepository.getOne(dto.getUserId());
        Recruitment recruitment = recruitmentRepository.getOne(dto.getRecruitmentId());
        ApplicationInfo rec = new ApplicationInfo();

        rec.setRecruitmentStatus(PROCESSED.getMessage());
        rec.setUser(user);
        rec.setRecruitment(recruitment);
        appInfoRepository.save(rec);
    }
//
//    //ini buat list all player who apply in club
//    @Override
//    public List<ApplicationInfoDto> listsAllApplicationInfo(String clubId) {
//        List<ApplicationInfoDto> list = new ArrayList<ApplicationInfoDto>();
//        List<ApplicationInfo> applicationInfos = appInfoRepository.findApplicationInfoByClubId(clubId);
//        Club club = clubRepository.findOne(clubId);
//
//        if (club != null) getApplicationData(list, applicationInfos);
//        return list;
//    }


    private void getApplicationData(List<ApplicationInfoDto> list, List<ApplicationInfo> applicationInfos) {
        for (ApplicationInfo rec : applicationInfos) {
            ApplicationInfoDto dto = new ApplicationInfoDto();
            dto.setApplicationInfoId(rec.getApplicationInfoId());
            dto.setUserId(rec.getUser().getUserId());
            dto.setUserName(rec.getUser().getUserName());
            dto.setRecruitmentStatus(PROCESSED.getMessage());
            list.add(dto);
        }
    }
//
//    @Override
//    public ApplicationInfoResponse applicationSuccess(String userId) {
//        ApplicationInfoResponse response = new ApplicationInfoResponse();
//        List<ApplicationInfo> applicationInfos = appInfoRepository.getAllApplicationInfoByUserId(userId);
//        List<ApplicationInfoDto> applicationInfoDtos = new ArrayList<ApplicationInfoDto>();
//        for (ApplicationInfo applicationInfo : applicationInfos) {
//            if (applicationInfo.getUser().getUserId().equals(userId)) {
//                ApplicationInfoDto appDto = new ApplicationInfoDto();
//                appDto.setApplicationInfoId(applicationInfo.getApplicationInfoId());
//                appDto.setUserId(applicationInfo.getUser().getUserId());
//                appDto.setUserName(applicationInfo.getUser().getUserName());
//                appDto.setRecruitmentStatus(APPROVED.getMessage());
//                applicationInfoDtos.add(appDto);
//            }
//        }
//        response.setResponse(applicationInfoDtos);
//        return response;
//    }

}