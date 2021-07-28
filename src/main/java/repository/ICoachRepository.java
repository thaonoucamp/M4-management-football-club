package repository;

import model.Coach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoachRepository extends PagingAndSortingRepository<Coach, Long> {
    Page<Coach> findAll(Pageable pageable);
    @Query("select c from Coach c where c.name like ?1")
    Iterable<Coach> findAllByName(String name);

}
