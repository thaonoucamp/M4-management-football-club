package service.type;

import model.Type;
import service.IGeneralService;

public interface ITypeService<T> extends IGeneralService<Type> {
    Iterable<Type>findByName(String name);
}
