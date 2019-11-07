package app.dto;

import java.util.List;

public class ApplicationInfoResponse {
    List<ApplicationInfoDto> response;

    public List<ApplicationInfoDto> getResponse() {
        return response;
    }

    public void setResponse(List<ApplicationInfoDto> response) {
        this.response = response;
    }
}
