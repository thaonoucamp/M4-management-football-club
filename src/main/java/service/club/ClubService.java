package service.club;

import model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IClubRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClubService implements IClubService {
    @Autowired
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

    @Override
    public List<Club> findByName(String name) {
        List<Club> list = new ArrayList<>();
        for (Club club : clubRepository.findAll()) {
            if (club.getName().equals(name)) {
                list.add(club);
            }
        }
        return list;
    }
}
