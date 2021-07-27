package repository;

import model.Club;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IClubRepository extends CrudRepository<Club, Long> {

    @Query("select c from Club c where c.name like :name")
    Iterable<Club> findByName(@Param("name") String name);
}
