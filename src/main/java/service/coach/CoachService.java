package service.coach;

import model.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import repository.ICoachRepository;

import java.util.Optional;

@Service
public class CoachService implements service.coach.ICoachService {

    @Autowired
    ICoachRepository coachRepository;

    @Override
    public Iterable<Coach> findAll() {
        return coachRepository.findAll();
    }

    @Override
    public Optional<Coach> findById(Long id) {
        return coachRepository.findById(id);
    }

    @Override
    public void save(Coach city) {
        coachRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        coachRepository.deleteById(id);
    }

    @Override
    public Page<Coach> findAll(Pageable pageable) {
        return coachRepository.findAll(pageable);
    }

    @Override
    public Iterable<Coach> findAllByName(String name) {
        return coachRepository.findAllByName(name);
    }
}
