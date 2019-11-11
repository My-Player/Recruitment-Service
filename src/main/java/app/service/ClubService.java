package app.service;

import app.dto.ClubDto;
import app.model.Club;

import java.util.List;

/**
 * Description goes here.
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 17/10/2019
 */
public interface ClubService {
    List<Club> getAllClub();
    Club convertToClubAndSave(ClubDto clubDto);
    Club getOne(String clubId);
}
