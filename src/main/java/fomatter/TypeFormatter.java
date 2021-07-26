package fomatter;
import model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.type.TypeService;

import java.text.ParseException;
import java.util.Locale;
@Component
public class TypeFormatter implements Formatter<Type> {
    @Autowired
    private TypeService typeService;

    public TypeFormatter(TypeService typeService) {
        this.typeService = typeService;
    }

    @Override
    public Type parse(String text, Locale locale) throws ParseException {
        return typeService.findById(Long.parseLong(text)).orElse(null);
    }

    @Override
    public String print(Type object, Locale locale) {
        return null;
    }
}
