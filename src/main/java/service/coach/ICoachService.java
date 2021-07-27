package service.coach;

import model.Coach;
import service.IGeneralService;

public interface ICoachService extends IGeneralService<Coach> {
    Iterable<Coach> findAllByName(String name);
}
