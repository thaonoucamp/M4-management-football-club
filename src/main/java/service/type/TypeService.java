package service.type;

import model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TypeRepository;
import service.IGeneralService;

import java.util.Optional;
@Service
public class TypeService implements IGeneralService<Type> {

    @Autowired
    private TypeRepository typeRepository;
    @Override
    public Iterable<Type> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Optional<Type> findById(Long id) {
        return typeRepository.findById(id);
    }

    @Override
    public void save(Type type) {
        typeRepository.save(type);
        typeRepository.flush();
    }

    @Override
    public void delete(Long id) {
        typeRepository.deleteById(id);
    }

    @Override
    public Iterable<Type> findByName(String name) {
        return typeRepository.findByName(name);
    }

}
