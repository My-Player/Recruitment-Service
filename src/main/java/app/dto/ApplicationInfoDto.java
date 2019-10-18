package app.dto;

public class ApplicationInfoDto {

    private String applicationInfoId;

    private String recruitmentStatus;

    private String userId;

    private String recruitmentId;

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getApplicationInfoId() {
        return applicationInfoId;
    }

    public String getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(String recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public void setApplicationInfoId(String applicationInfoId) {
        this.applicationInfoId = applicationInfoId;
    }

    public String getRecruitmentStatus() {
        return recruitmentStatus;
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
