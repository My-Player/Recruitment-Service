package app.repository;

import app.model.Club;
import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * repository to maintain user stuff
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */

@Repository
public interface UsersDataRepository extends JpaRepository<User, String> {
    List<User> getAllByClub(Club club);
}
