package app.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */
@Entity
@Table(name = "RECRUITMENT_DATA")
public class Recruitment implements Serializable {

    @Column(name = "RECRUITMENT_ID")
    @Id
    private String recruitmentId;

    @Column(name = "RECRUITMENT_DESCRIPTION")
    private String description;

    @Column(name = "RECRUITMENT_CREATED_DATE")
    private Date createdDate;

    @Column(name = "RECRUITMENT_PROVINCE")
    private String province;

    @ManyToOne
    @JoinColumn(name = "CLUB_ID", nullable = true)
    private Club club;

    //logo

    public String getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(String recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
