package repository;

import model.Coach;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoachRepository extends PagingAndSortingRepository<Coach, Long> {
    Iterable<Coach> findAllByName(String coach);

}
