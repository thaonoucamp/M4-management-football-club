package service.club;

import model.Club;
import org.springframework.stereotype.Service;
import repository.IClubRepository;

import java.util.Optional;

@Service
public class ClubService implements IClubService {
    private IClubRepository clubRepository;

    @Override
    public Iterable<Club> findAll() {
        return clubRepository.findAll();
    }

    @Override
    public Optional<Club> findById(Long id) {
        return clubRepository.findById(id);
    }

    @Override
    public void save(Club club) {
        clubRepository.save(club);
    }

    @Override
    public void delete(Long id) {
        clubRepository.deleteById(id);
    }
}
