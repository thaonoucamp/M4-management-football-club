package fomatter;

import model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.club.IClubService;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ClubFormatter implements Formatter<Club> {
    private IClubService clubService;

    @Autowired
    public ClubFormatter(IClubService countryService) {
        this.clubService = countryService;
    }

    @Override
    public Club parse(String text, Locale locale) throws ParseException {
        return this.clubService.findById(Long.valueOf(text)).get();
    }

    @Override
    public String print(Club object, Locale locale) {
        return null;
    }
}
