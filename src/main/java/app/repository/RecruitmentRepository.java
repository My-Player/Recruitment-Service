package app.repository;

import app.model.Club;
import app.model.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * repository to maintain recruitment stuff
 *
 * @author patrick.kwan
 * @since 15/10/2019
 */
@Repository
public interface RecruitmentRepository extends JpaRepository<Recruitment, String> {
    List<Recruitment> getAllByClub(Club club);
}
