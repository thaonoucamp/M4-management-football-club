package service.coach;

import model.Coach;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import service.IGeneralService;

public interface ICoachService extends IGeneralService<Coach> {
    Page<Coach> findAll(Pageable pageable);
    Iterable<Coach> findAllByName(String name);
}
