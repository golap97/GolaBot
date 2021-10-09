package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class ClearChat extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        String[] message = e.getMessage().getContentRaw().split(" ");

        if (message[0].equalsIgnoreCase(".clear")) {
            List<Message> messages = e.getChannel().getHistory().retrievePast(Integer.parseInt(message[1])).complete();
            e.getChannel().deleteMessages(messages).queue();
        }
    }


}
