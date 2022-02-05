package dagnachew.leul.bot.commands.ebaadcommands;

import dagnachew.leul.bot.commands.CommandContext;
import dagnachew.leul.bot.commands.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class EbaadFanCommand implements ICommand {
    @Override
    public void handle(CommandContext ctx) {
        TextChannel channel = ctx.getChannel();

        channel.sendMessage(new EmbedBuilder()
                .setAuthor("TheKobe5s#8244")
                .setImage("https://i.postimg.cc/dV2G9Lqr/Screenshot-2022-02-02-211519.png")
                .setColor(Color.BLACK)
                .build()
        ).queue();
    }

    @Override
    public String getName() {
        return "ebaad";
    }

    @Override
    public String getHelp() {
        return "Ebaad Propaganda";
    }

    @Override
    public List<String> getAliases() {
        return Arrays.asList("arabicguy","halal");
    }
}
