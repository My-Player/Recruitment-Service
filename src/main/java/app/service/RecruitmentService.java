package app.service;

import app.dto.RecruitmentDto;
import app.model.Recruitment;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 15/10/2019
 */
public interface RecruitmentService {
    Recruitment saveRecruitment(Recruitment recruitment);
    Recruitment convertToRecruitment(RecruitmentDto recruitmentDto);
}
