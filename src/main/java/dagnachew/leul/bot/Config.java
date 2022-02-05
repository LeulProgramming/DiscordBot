package dagnachew.leul.bot;
import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private static final Dotenv dotenv = Dotenv.configure().filename("example.env").load();

    public static String get(String key) {
        return dotenv.get(key.toUpperCase());
    }
}
