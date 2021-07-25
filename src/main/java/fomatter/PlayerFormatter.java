package fomatter;

import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.player.IPlayerService;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PlayerFormatter implements Formatter<Player> {

    IPlayerService playerServiceService;

    @Autowired
    public PlayerFormatter(IPlayerService countryService) {
        this.playerServiceService = countryService;
    }

    @Override
    public Player parse(String text, Locale locale) throws ParseException {
        return this.playerServiceService.findById(Long.valueOf(text)).get();
    }

    @Override
    public String print(Player object, Locale locale) {
        return null;
    }
}
