package app.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "recruitment_info")
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class ApplicationInfo implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name="application_info_id")
    private String applicationInfoId;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "recruitment_status")
    private String recruitmentStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Recruitment recruitment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getApplicationInfoId() {
        return applicationInfoId;
    }

    public void setApplicationInfoId(String applicationInfoId) {
        this.applicationInfoId = applicationInfoId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getRecruitmentStatus() {
        return recruitmentStatus;
    }

    public void setRecruitmentStatus(String recruitmentStatus) {
        this.recruitmentStatus = recruitmentStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }
}
