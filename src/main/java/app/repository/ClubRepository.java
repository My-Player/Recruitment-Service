package app.repository;

import app.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * repository to maintain club stuff
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 17/10/2019
 */
@Repository
public interface ClubRepository extends JpaRepository<Club, String> {

}
