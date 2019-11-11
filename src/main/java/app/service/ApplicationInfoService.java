package app.service;

import app.dto.ApplicationInfoDto;
import app.model.ApplicationInfo;

import java.util.List;

public interface ApplicationInfoService {
    //apply to club
    ApplicationInfo saveApplicationInfo(ApplicationInfoDto dto);

    //To see all of the applied request to clubs;
    List<ApplicationInfo> listsAllApplicationInfoByClubId(String clubId);

    //ApplicationInfoResponse applicationSuccess(String userId);

    void doSigningPlayer(String userId, String clubId);

    void doRejectPlayer(String applicationId);

    ApplicationInfo findByUserIdAndClubId(String userId, String clubId);
}
