package app.repository;

import app.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 17/10/2019
 */
public interface ClubRepository extends JpaRepository<Club, String> {
    Club findClubByClubId(String clubId);
}
