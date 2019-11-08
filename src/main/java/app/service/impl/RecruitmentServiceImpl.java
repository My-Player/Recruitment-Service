package app.service.impl;

import app.dto.RecruitmentDto;
import app.model.Club;
import app.model.Recruitment;
import app.repository.ClubRepository;
import app.repository.RecruitmentRepository;
import app.service.RecruitmentService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    private static final Logger LOGGER = LogManager.getLogger(RecruitmentServiceImpl.class.getName());

    private final RecruitmentRepository recruitmentRepository;
    private final ClubRepository clubRepository;

    public RecruitmentServiceImpl(RecruitmentRepository recruitmentRepository, ClubRepository clubRepository) {
        this.recruitmentRepository = recruitmentRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public Recruitment saveRecruitment(RecruitmentDto recruitmentDto) {

        Club club = clubRepository.findClubByClubId(recruitmentDto.getClubId());
        Recruitment recruitment = new Recruitment();

        try{
            recruitment.setProvince(recruitmentDto.getProvince());
            recruitment.setDescription(recruitmentDto.getDescription());
            recruitment.setTitle(recruitmentDto.getTitle());
            recruitment.setClub(club);

        }catch(Exception e){
            LOGGER.info(e.getMessage());
        }
        return recruitmentRepository.save(recruitment);
    }

    @Override
    public Recruitment convertToRecruitment(RecruitmentDto recruitmentDto) {
        return null;
    }

    @Override
    public List<Recruitment> getAllRecruitment() {
        return recruitmentRepository.findAll();
    }
}
