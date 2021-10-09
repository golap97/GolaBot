package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InviteCommand extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        int timeString = 2880;
        String[] message = e.getMessage().getContentRaw().split(" ");
        if(message[0].equalsIgnoreCase(".invite") && message.length == 1){
            e.getChannel().sendMessage("To use .invite command do: .invite create").queue();
        } else if (message.length >= 2 && message[0].equalsIgnoreCase(".invite") && message[1].equalsIgnoreCase("create")) {
            e.getChannel().sendMessage("Hey " + e.getAuthor().getName() + "! You want to create invite someone?").queue();
            e.getChannel().sendMessage("Give them this invite link: " + e.getChannel().createInvite().setMaxAge(timeString).complete().getUrl()).queue();
            e.getChannel().sendMessage("The invite expires in: " + timeString/60 + " hours.").queue();
        }
    }

}
