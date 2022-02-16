package dagnachew.leul.bot.commands.wordhunt;

import dagnachew.leul.bot.commands.CommandContext;
import dagnachew.leul.bot.commands.ICommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.graalvm.compiler.word.Word;

public class HangmanCommand implements ICommand {


    @Override
    public void handle(CommandContext ctx) {
        TextChannel channel = ctx.getChannel();
        JDA jda = ctx.getJDA();
        WordGenerator generator = new WordGenerator();
        HangmanGame game = new HangmanGame(generator.getSelectedWord());
        System.out.println(game.getBoard());

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
