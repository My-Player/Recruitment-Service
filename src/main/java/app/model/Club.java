package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 17/10/2019
 */

@Entity
@Table(name = "CLUB_DATA")
public class Club implements Serializable {

    @Column(name = "CLUB_ID")
    @Id
    private String clubId;

    @Column(name = "CLUB_ADDRESS")
    private String clubAddress;

    @Column(name = "CLUB_NAME")
    private String clubName;

    @Column(name = "CLUB_RATING")
    private String clubRating;

    @OneToMany(mappedBy ="userId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column
    private List<UsersData> members = new ArrayList<UsersData>();

    @Column(name = "RECRUITMENT_LIST")
    @OneToMany(mappedBy ="recruitmentId",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Recruitment> recruitment = new ArrayList<Recruitment>();

    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column
    private List<UsersData> applyList = new ArrayList<UsersData>();

    public List<Recruitment> getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(List<Recruitment> recruitment) {
        this.recruitment = recruitment;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubAddress() {
        return clubAddress;
    }

    public void setClubAddress(String clubAddress) {
        this.clubAddress = clubAddress;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubRating() {
        return clubRating;
    }

    public void setClubRating(String clubRating) {
        this.clubRating = clubRating;
    }

    public List<UsersData> getMembers() {
        return members;
    }

    public void setMembers(List<UsersData> members) {
        this.members = members;
    }
}

