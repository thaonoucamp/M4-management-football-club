package repository;

import model.Player;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends PagingAndSortingRepository<Player, Long> {
}
