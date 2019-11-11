package app.repository;


import app.model.ApplicationInfo;
import app.model.Club;
import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationInfoRepository extends JpaRepository<ApplicationInfo,String> {

    List<ApplicationInfo> findAllByClub(Club club);

    ApplicationInfo findByUserAndClub(User user, Club club);

}
