package fr.ttanesque.empirebot.commands.utils.treatment;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.regex.Matcher;

import fr.ttanesque.empirebot.commands.treatment.MessageTreatment;

/**
 * Treat the demand to generate google search.
 */
public class GoogleTreatment extends MessageTreatment implements Runnable {

    /**
     * The constructor.
     *
     * @param text  the matcher get with regex in
     * {@link fr.ttanesque.empirebot.commands.Google}
     * @param event the message.
     */
    public GoogleTreatment(final Matcher text, final MessageReceivedEvent event) {
        super(text, event);
    }

    @Override
    public final void run() {
        if (this.checkBotChannel()) {
            String recherche = "https://www.google.com/search?q=";
            recherche += this.getText().group(1).replace(' ', '+');

            this.getEventMessage().getChannel().sendMessage(recherche).queue();
        }
    }
}
