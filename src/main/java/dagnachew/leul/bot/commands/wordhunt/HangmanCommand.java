package dagnachew.leul.bot.commands.wordhunt;

import dagnachew.leul.bot.commands.CommandContext;
import dagnachew.leul.bot.commands.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.graalvm.compiler.word.Word;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class HangmanCommand extends ListenerAdapter implements ICommand{

    public HangmanGame hangmanGame;

    @Override
    public void handle(CommandContext ctx) {
        TextChannel channel = ctx.getChannel();
        JDA jda = ctx.getJDA();

        WordGenerator generator = new WordGenerator();
        hangmanGame = new HangmanGame(generator.getSelectedWord(),channel);
        HangmanListener listener = new HangmanListener();

        listener.setGame(hangmanGame);
        hangmanGame.setUser(ctx.getMessage().getAuthor());
        listener.setGameStarted(true);

    }


    @Override
    public String getName() {
        return "hangman";
    }

    @Override
    public String getHelp() {
        return "allows the user to play a game of hangman";
    }
}
