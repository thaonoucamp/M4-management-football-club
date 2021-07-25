package service.player;

import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.IPlayerRepository;

import java.util.Optional;

@Service
public class PlayerService implements service.player.IPlayerService {
    @Autowired
    IPlayerRepository playerRepository;
    @Override
    public Iterable<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    @Override
    public void save(Player country) {
        playerRepository.save(country);
    }

    @Override
    public void delete(Long id) {
        playerRepository.deleteById(id);
    }
}
