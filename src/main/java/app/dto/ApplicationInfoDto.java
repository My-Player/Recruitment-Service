package app.dto;

public class ApplicationInfoDto {

    private String recruitmentStatus;

    private String userId;

    private String clubId;

    public String getRecruitmentStatus() {
        return recruitmentStatus;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public void setRecruitmentStatus(String recruitmentStatus) {
        this.recruitmentStatus = recruitmentStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
