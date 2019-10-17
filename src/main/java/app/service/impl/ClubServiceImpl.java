package app.service.impl;

import app.model.Club;
import app.repository.ClubRepository;
import app.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description goes here.
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
}
