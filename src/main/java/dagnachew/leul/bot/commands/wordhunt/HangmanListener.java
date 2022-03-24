package dagnachew.leul.bot.commands.wordhunt;

import dagnachew.leul.bot.Config;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
        if(gameStarted) {
            if(event.getMessage().getContentRaw().equalsIgnoreCase("giveup")) {
                gameStarted = false;
                game.sendBoard(game.getWord().replaceAll("", " "));
            }
            else if(event.getMessage().getContentRaw().equals(game.getWord())) {
                gameStarted = false;
                game.sendBoard(game.getWord().replaceAll("", " "));
            }
            else if(gameStarted && game.getUser() == event.getAuthor()) {
                String guess = event.getMessage().getContentRaw().substring(0);
                game.onGuess(guess);
            }
            else if(game.getBoard() != null) {
                if(!game.getBoard().contains("_")) {
                    gameStarted = false;
                }
            }
        }

    }
}
