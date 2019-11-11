package app.model;

import app.generator.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Date;

@Entity
@Table(name = "club")
public class Club implements Serializable {

    @Column(name = "club_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @GenericGenerator(
            name = "book_seq",
            strategy = "app.generator.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CL"),
                    @org.hibernate.annotations.Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")})
    private String clubId;

    @Column(name = "club_name")
    private String clubName;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "club_city")
    private String clubCity;

    @Column(name = "club_logo")
    private String clubLogo;

    public String getClubLogo() {
        return clubLogo;
    }

    public void setClubLogo(String clubLogo) {
        this.clubLogo = clubLogo;
    }

    public int getClubMembers() {
        return clubMembers;
    }

    public void setClubMembers(int clubMembers) {
        this.clubMembers = clubMembers;
    }

    @Column(name = "club_address")
    private String clubAddress;

    @Column(name = "club_members_number")
    private int clubMembers;

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getClubCity() {
        return clubCity;
    }

    public void setClubCity(String clubCity) {
        this.clubCity = clubCity;
    }

    public String getClublogo() {
        return clubLogo;
    }

    public void setClublogo(String clublogo) {
        this.clubLogo = clublogo;
    }

    public String getClubAddress() {
        return clubAddress;
    }

    public void setClubAddress(String clubAddress) {
        this.clubAddress = clubAddress;
    }
}

