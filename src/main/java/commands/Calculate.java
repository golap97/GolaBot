package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Calculate extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        String[] message = e.getMessage().getContentRaw().split(" ");


        if (message[0].equalsIgnoreCase(".calculate") && message.length == 1) {
            e.getChannel().sendMessage("To use this command, type(without brackets): .calculate [add/sub/mul/div] [first-num] [second-num]").queue();
        } else if (message[0].equalsIgnoreCase(".calculate") && message[1].equalsIgnoreCase("add")) {
            double num1 = Double.parseDouble(message[2]);
            double num2 = Double.parseDouble(message[3]);
            e.getChannel().sendMessage("Here's ur result: " + (num1 + num2)).queue();
        } else if (message[0].equalsIgnoreCase(".calculate") && message[1].equalsIgnoreCase("sub")) {
            double num1 = Double.parseDouble(message[2]);
            double num2 = Double.parseDouble(message[3]);
            e.getChannel().sendMessage("Here's ur result: " + (num1 - num2)).queue();
        } else if (message[0].equalsIgnoreCase(".calculate") && message[1].equalsIgnoreCase("mul")) {
            double num1 = Double.parseDouble(message[2]);
            double num2 = Double.parseDouble(message[3]);
            e.getChannel().sendMessage("Here's ur result: " + (num1 * num2)).queue();
        } else if (message[0].equalsIgnoreCase(".calculate") && message[1].equalsIgnoreCase("div")) {
            double num1 = Double.parseDouble(message[2]);
            double num2 = Double.parseDouble(message[3]);
            e.getChannel().sendMessage("Here's ur result: " + (num1 / num2)).queue();
        }
    }
}
