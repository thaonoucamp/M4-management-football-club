package fomatter;

import model.Club;
import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ClubFormatter implements Formatter<Club> {

    @Override
    public Club parse(String text, Locale locale) throws ParseException {
        return null;
    }

    @Override
    public String print(Club object, Locale locale) {
        return null;
    }
}
