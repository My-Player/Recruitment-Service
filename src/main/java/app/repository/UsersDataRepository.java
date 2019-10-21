package app.repository;

import app.model.UsersData;
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
public interface UsersDataRepository extends JpaRepository<UsersData, String> {
    UsersData findByUserId(String id);
}