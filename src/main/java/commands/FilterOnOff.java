package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class FilterOnOff extends ListenerAdapter {

    public static boolean filterOn = true;


    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equalsIgnoreCase(".togglefilter") && filterOn) {
            filterOn = false;
            event.getChannel().sendMessage("Filtr słów został wyłączony przez " +
                    event.getMember().getUser().getName()).queue();

        } else if (event.getMessage().getContentRaw().equalsIgnoreCase(".togglefilter") && filterOn == false) {
            filterOn = true;
            event.getChannel().sendMessage("Filtr słów został włączony przez " +
                    event.getMember().getUser().getName()).queue();
        }
    }
}
