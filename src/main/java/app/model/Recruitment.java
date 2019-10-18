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

    @Column(name = "recruitment_id")
    @Id
    private String recruitmentId;

    @Column
    @OneToMany(mappedBy ="id",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> applicationList;

    @Column
    private String description;

    @Column
    private Date createdDate;

    @Column
    private String province;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "club")
    private Club club;



    //club many to one

    //logo


    public String getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(String recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public List<User> getApplicationList() {
        return applicationList;
    }

    public void setApplicationList(List<User> applicationList) {
        this.applicationList = applicationList;
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
