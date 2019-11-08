package app.repository;

import app.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 17/10/2019
 */
public interface ClubRepository extends JpaRepository<Club, String> {

    @Query("select a from Club a where a.clubCity = ?1 order by a.clubName asc")
    List<Club> findClubByClubCity(String clubCity);

    Club findClubByClubId(String clubId);

}
