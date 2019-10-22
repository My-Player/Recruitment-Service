package app.service;

import app.dto.ApplicationInfoDto;

import java.util.List;

public interface ApplicationInfoService {

    public void saveApplicationInfo(ApplicationInfoDto dto);

    public List<ApplicationInfoDto> listsAllApplicationInfo(String clubId);


    //TODO see all of the applied request to clubs;
}
