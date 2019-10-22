package app.repository;

import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */

@Repository
<<<<<<< HEAD
public interface UsersDataRepository extends JpaRepository<User, String> {
    User findById(String id);

=======
public interface UsersDataRepository extends JpaRepository<UsersData, String> {
    UsersData findByUserId(String id);
>>>>>>> origin/My-Player-Recruitment-1
}
