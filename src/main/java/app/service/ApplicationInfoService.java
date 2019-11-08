package app.service;

import app.dto.ApplicationInfoDto;
import app.dto.response.ApplicationInfoResponse;

public interface ApplicationInfoService {

     void saveApplicationInfo(ApplicationInfoDto dto);

     ApplicationInfoResponse listsAllApplicationInfo(String clubId);

     ApplicationInfoResponse applicationSuccess(String clubId,String userId);

     ApplicationInfoResponse applicationRejected(String clubId, String userId);


    //TODO see all of the applied request to clubs;
}
