package dagnachew.leul.bot.commands.wordhunt;

import dagnachew.leul.bot.commands.CommandContext;
import dagnachew.leul.bot.commands.ICommand;

public class HangmanCommand implements ICommand {


    @Override
    public void handle(CommandContext ctx) {

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
