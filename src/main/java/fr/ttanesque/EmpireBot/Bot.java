package fr.ttanesque.EmpireBot;

import fr.ttanesque.EmpireBot.commands.Clean;
import fr.ttanesque.EmpireBot.commands.Google;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;
import java.io.IOException;

/**
 * the main class who start the bot and register the listener.
 */
public final class Bot {

    /**
     * The main methods.
     * @param args the argument
     * @throws LoginExceptionnot connected
     * @throws InterruptedException InterruptedException
     * @throws IOException config...
     */
    public static void main(final String[] args)
    throws LoginException, InterruptedException, IOException {
        //start bot 1 shard
        JDA jda = JDABuilder
                .createDefault(Config.getConfigInstance().getInitConf().getToken())
                .build();
        // we wait the jda isready
        jda.addEventListener(new Clean());
        jda.addEventListener(new Google());
    }

    /**
     * Basic constructor.
     */
    private Bot() {
    }
}
