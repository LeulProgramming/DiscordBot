package dagnachew.leul.bot.commands.wordhunt;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HangmanGame {

    private String board;

    public HangmanGame(String word) {
        board = word.replaceAll("[a-z]", "_");
    }

    public String getBoard() {
        return board;
    }
}
