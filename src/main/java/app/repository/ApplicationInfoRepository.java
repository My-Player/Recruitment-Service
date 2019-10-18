package app.repository;


import app.model.ApplicationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationInfoRepository extends JpaRepository<ApplicationInfo,String> {

    @Query(value = "select * FROM `ApplicationInfo` WHERE club_id LIKE  :clubId order by trans_time desc",nativeQuery = true)
    List<ApplicationInfo> findApplicationInfoByClubId(@Param("clubId") String clubId);

}
