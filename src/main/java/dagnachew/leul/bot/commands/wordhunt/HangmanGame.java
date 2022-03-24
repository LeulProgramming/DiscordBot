package dagnachew.leul.bot.commands.wordhunt;

import dagnachew.leul.bot.commands.CommandContext;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Invite;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.internal.JDAImpl;
import org.apache.commons.collections4.list.TreeList;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.*;
import java.util.List;

public class HangmanGame extends ListenerAdapter {

    private String board;
    private String word;
    private TextChannel channel;
    private User user;
    private int points;
    public HangmanGame() {

    }
    public HangmanGame(String word, TextChannel channel) {

        this.word = word;
        points = word.length() * 100;
        board = word.replaceAll("[a-z]", "_ ");
        this.channel = channel;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBoard() {
        return board;
    }

    public String getWord() {
        return word;
    }

    public void sendBoard(String board) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(Color.cyan)
                .setTitle("Guess the Word!")
                .setAuthor(user.getName())
                .setFooter("Score: " + points)
                .setDescription("```" + board + "```");
        points /= 2;
        channel.sendMessage(embed.build()).queue();
    }

    public User getUser() {
        return user;
    }

    public int getPoints() {
        return points;
    }

    public void onGuess(String letter) {
        System.out.println(word);
        String temp = board.replaceAll(" ", "");
        char ch = letter.charAt(0);
        Queue<Character> queue = new LinkedList<>();
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ch) {
                queue.add(word.charAt(i));
            }
            else {
                queue.add(temp.charAt(i));
            }
        }
        board = "";
        while(!queue.isEmpty()) {
            board += queue.remove();
        }

        sendBoard(getBoard().replaceAll("" , " "));

        System.out.println(board);
    }

}
