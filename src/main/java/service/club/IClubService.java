package service.club;

import model.Club;
import service.IGeneralService;

import java.util.List;

public interface IClubService extends IGeneralService<Club> {

    List<Club> findByName(String name);
}
