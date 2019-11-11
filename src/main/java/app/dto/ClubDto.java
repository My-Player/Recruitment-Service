package app.dto;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 17/10/2019
 */
public class ClubDto {

    private String clubName;
    private String clubAddress;
    private String clubCity;
    private String logo;

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubAddress() {
        return clubAddress;
    }

    public void setClubAddress(String clubAddress) {
        this.clubAddress = clubAddress;
    }

    public String getClubCity() {
        return clubCity;
    }

    public void setClubCity(String clubCity) {
        this.clubCity = clubCity;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
