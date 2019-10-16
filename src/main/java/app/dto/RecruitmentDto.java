package app.dto;
/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */
public class RecruitmentDto {

    private String description;

    private String province;

    private String clubId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }
}
