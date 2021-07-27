package service.user;

import model.User;
import service.IGeneralService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {
    Optional<User> findByUserName(String username);
}
