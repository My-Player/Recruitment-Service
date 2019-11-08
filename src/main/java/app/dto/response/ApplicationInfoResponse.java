package app.dto.response;

import app.dto.ApplicationInfoDto;

import java.util.List;

public class ApplicationInfoResponse {

    private String clubId;
    private List<ApplicationInfoDto> response;

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public List<ApplicationInfoDto> getResponse() {
        return response;
    }

    public void setResponse(List<ApplicationInfoDto> response) {
        this.response = response;
    }
}
