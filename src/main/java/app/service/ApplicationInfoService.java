package app.service;

import app.dto.ApplicationInfoDto;
import app.dto.ApplicationInfoResponse;
import app.model.ApplicationInfo;

import java.util.List;

public interface ApplicationInfoService {

     void saveApplicationInfo(ApplicationInfoDto dto);

//     List<ApplicationInfoDto> listsAllApplicationInfo(String clubId);

//     ApplicationInfoResponse applicationSuccess(String userId);

    //To see all of the applied request to clubs;
}
