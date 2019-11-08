package app.dto.response;

import app.dto.RecruitmentDto;

import java.util.List;

public class RecruitmentResponse {
    private List<RecruitmentDto> data;

    public List<RecruitmentDto> getData() {
        return data;
    }

    public void setData(List<RecruitmentDto> data) {
        this.data = data;
    }
}
