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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static app.constant.StatusConstant.*;

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

        rec.setRecruitmentStatus(PROCESSED.getMessage());
        rec.setUser(user);
        rec.setRecruitment(recruitment);
        appInfoRepository.save(rec);
    }

    //ini buat list all player who apply in club
    @Override
    public ApplicationInfoResponse listsAllApplicationInfo(String clubId) {
        ApplicationInfoResponse response = new ApplicationInfoResponse();
        List<ApplicationInfoDto> list = new ArrayList();
        List<ApplicationInfo> applicationInfos = appInfoRepository.findApplicationInfoByClubId(clubId);
        Club club = clubRepository.findOne(clubId);

        if (club != null) getApplicationData(list,applicationInfos);
        response.setResponse(list);
        return response;
    }


    private void getApplicationData(List<ApplicationInfoDto> list,List<ApplicationInfo> applicationInfos){
        for (ApplicationInfo rec : applicationInfos) {
            ApplicationInfoDto dto = new ApplicationInfoDto();
            dto.setApplicationInfoId(rec.getApplicationInfoId());
            dto.setUserId(rec.getUser().getUserId());
            dto.setUserName(rec.getUser().getUserName());
            dto.setRecruitmentId(rec.getRecruitment().getRecruitmentId());
            dto.setRecruitmentStatus(PROCESSED.getMessage());
            list.add(dto);
        }
    }


    @Override
    public ApplicationInfoResponse applicationSuccess(String clubId,String userId) {
        Club club = clubRepository.findClubByClubId(clubId);
        ApplicationInfoResponse response = new ApplicationInfoResponse();
        List<ApplicationInfo> applicationInfos = appInfoRepository.getAllApplicationInfoByUserId(userId);
        List<ApplicationInfoDto> applicationInfoDtos = new ArrayList();
        for(ApplicationInfo applicationInfo : applicationInfos){
            if(applicationInfo.getUser().getUserId().equals(userId)){
                ApplicationInfoDto appDto = new ApplicationInfoDto();
                appDto.setApplicationInfoId(applicationInfo.getApplicationInfoId());
                appDto.setRecruitmentId(applicationInfo.getRecruitment().getRecruitmentId());
                appDto.setUserId(applicationInfo.getUser().getUserId());
                appDto.setUserName(applicationInfo.getUser().getUserName());
                appDto.setRecruitmentStatus(APPROVED.getMessage());
                applicationInfoDtos.add(appDto);
            }
        }
        response.setClubId(club.getClubId());
        response.setResponse(applicationInfoDtos);
        return response;
    }

    @Override
    public ApplicationInfoResponse applicationRejected(String clubId, String userId) {

        ApplicationInfoResponse response = new ApplicationInfoResponse();
        Club club = clubRepository.findClubByClubId(clubId);
        List<ApplicationInfoDto> applicationInfoDtos = new ArrayList();
        List<ApplicationInfo> applicationInfos = appInfoRepository.getAllApplicationInfoByUserId(userId);

        for(ApplicationInfo applicationInfo : applicationInfos){
            if(applicationInfo.getUser().getUserId().equals(userId)){
                ApplicationInfoDto appDto = new ApplicationInfoDto();
                appDto.setRecruitmentStatus(REJECTED.getMessage());
                appDto.setApplicationInfoId(applicationInfo.getApplicationInfoId());
                appDto.setUserId(applicationInfo.getUser().getUserId());
                appDto.setRecruitmentId(applicationInfo.getRecruitment().getRecruitmentId());
                appDto.setUserName(applicationInfo.getUser().getUserName());
                applicationInfoDtos.add(appDto);
            }
        }
        response.setClubId(club.getClubId());
        response.setResponse(applicationInfoDtos);
        return response;
    }

}