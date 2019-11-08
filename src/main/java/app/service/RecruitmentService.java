package app.service;

import app.dto.RecruitmentDto;
import app.model.Recruitment;

import java.util.List;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */
public interface RecruitmentService {
    Recruitment saveRecruitment(RecruitmentDto recruitmentDto);
    List<Recruitment> getAllRecruitment();



}
