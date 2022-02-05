package dagnachew.leul.bot.commands.dictionarycommands;

import dagnachew.leul.bot.commands.CommandContext;
import dagnachew.leul.bot.commands.ICommand;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

public class DictionaryCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
         TextChannel channel = ctx.getChannel();
         List<String> args = ctx.getArgs();
         Dictionary dictionary = new Dictionary();
         if(args.isEmpty()) {
             channel.sendMessage("No Word Given").queue();
             return;
         }

         dictionary.getDefinition(args.get(0));

    }

    @Override
    public String getName() {
        return "dictionary";
    }

    @Override
    public String getHelp() {
        return "returns the definition of a word";
    }
}
