package dagnachew.leul.bot;

import dagnachew.leul.bot.database.SQLiteDataSource;
import me.duncte123.botcommons.web.WebUtils;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

public class Bot {


     private Bot() throws LoginException, SQLException {
         SQLiteDataSource.getConnection();

         WebUtils.setUserAgent("Mozilla/5.0 Beta#3016 / The President Assad#3536");
        JDABuilder.createDefault(
                Config.get("token"),
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.GUILD_VOICE_STATES,
                        GatewayIntent.GUILD_EMOJIS
                )
                .addEventListeners(new ListenerClass())
                .setActivity(Activity.watching("Nothingness..."))
                .build();
    }

    public static void main(String[] args) throws LoginException, SQLException {
        new Bot();
    }
}
