package repository;

import model.Club;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClubRepository extends CrudRepository<Club, Long> {

}
