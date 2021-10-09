package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter extends ListenerAdapter {

    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (FilterOnOff.filterOn == true) {

            final String regex = "(\\.+$)";
            String[] BadWords = {".", ","};
            String message = event.getMessage().getContentRaw();

            final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            final Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {
                event.getMessage().delete().queue();
            }
//            for (int i = 0; i < message.length; i++) {
//                for (int b = 0; b < BadWords.length; b++) {
//                    if (message[i].equalsIgnoreCase(regex)) {
//                        event.getMessage().delete().queue();
//                        EmbedBuilder eb = new EmbedBuilder();
//                        eb.setTitle("Gdzie z tą kropką");
//                        eb.setImage("https://66.media.tumblr.com/0195105075e6a0586c50acfef846d0ae/e944983a12a24678-b6/s640x960/9f61f8693946285518dad407e2c9c8e418fb599f.jpg");
//                        event.getChannel().sendMessage(eb.build()).queue();
//                        event.getChannel().sendMessage("Damn son. Brocha is approaching.").queue();
//                    }
//                }
//            }
        } else if (FilterOnOff.filterOn == false) {
            System.out.println("Filtr jest wyłączony");
        }
    }
}
