package app.service.impl;

import app.dto.ClubDto;
import app.model.Club;
import app.repository.ClubRepository;
import app.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * service to maintain club stuff
 *
 * @author patrick.kwan
 * @version 0.1
 * @since 17/10/2019
 */
@Service
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;

    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository){
        this.clubRepository = clubRepository;
    }

    @Override
    public List<Club> getAllClub() {
        return clubRepository.findAll();
    }

    @Override
    public Club convertToClubAndSave(ClubDto clubDto) {
        Club newClub = new Club();
        newClub.setClubCity(clubDto.getClubCity());
        newClub.setClublogo(clubDto.getLogo());
        newClub.setClubName(clubDto.getClubName());
        newClub.setClubAddress(clubDto.getClubAddress());
        newClub.setCreatedDate(new Date());
        newClub.setClubMembers(0);
        clubRepository.save(newClub);
        return newClub;
    }

    @Override
    public Club getOne(String clubId){
        return clubRepository.getOne(clubId);
    }
}
