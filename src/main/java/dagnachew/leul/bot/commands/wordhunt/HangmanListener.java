package dagnachew.leul.bot.commands.wordhunt;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HangmanListener extends ListenerAdapter {

    private static boolean gameStarted;
    private static HangmanGame game;

    public HangmanListener() {
        gameStarted = false;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public void setGame(HangmanGame game) {
        this.game = game;
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if(gameStarted && game.getUser() == event.getAuthor()) {
            String guess = event.getMessage().getContentRaw().substring(0);
            game.onGuess(guess);
        }
        if(game.getBoard() != null) {
            if(!game.getBoard().contains("_")) {
                gameStarted = false;
            }
        }
    }
}
