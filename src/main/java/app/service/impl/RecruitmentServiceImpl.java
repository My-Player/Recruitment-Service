package app.service.impl;

import app.dto.RecruitmentDto;
import app.model.Club;
import app.model.Recruitment;
import app.repository.ClubRepository;
import app.repository.RecruitmentRepository;
import app.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service to maintain recruitment stuff
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    private final RecruitmentRepository recruitmentRepository;
    private final ClubRepository clubRepository;

    @Autowired
    public RecruitmentServiceImpl(RecruitmentRepository recruitmentRepository,
                                  ClubRepository clubRepository){
        this.recruitmentRepository = recruitmentRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public Recruitment saveRecruitment(Recruitment recruitment) {
        recruitmentRepository.save(recruitment);
        return recruitment;
    }

    @Override
    public Recruitment convertToRecruitment(RecruitmentDto recruitmentDto) {
        return null;
    }

    @Override
    public List<Recruitment> getAllRecruitment() {
        List<Recruitment> getAllRecruitment = recruitmentRepository.getAllRecruitment();
        return getAllRecruitment;
    }

    @Override
    public List<Recruitment> getAllByClub(String clubId) {
        Club club = clubRepository.getOne(clubId);
        return recruitmentRepository.getAllByClub(club);
    }
}
