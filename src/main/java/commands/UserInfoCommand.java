package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfoCommand extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent e) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String[] message = e.getMessage().getContentRaw().split(" ");

        if (message.length == 1 && message[0].equalsIgnoreCase(".user")) {
            e.getChannel().sendMessage("To get a user info, type .user [name]").queue();
        } else if (message.length == 2 && message[0].equalsIgnoreCase(".user")) {
            String userName = message[1];
            User user = (User) e.getGuild().getMembersByName(userName, true).get(0).getUser();
            String avatar = user.getAvatarUrl();

            EmbedBuilder avatarEmber = new EmbedBuilder();

            avatarEmber.setTitle(userName + "'s info:");
            avatarEmber.setColor(Color.BLUE);
            avatarEmber.addField("Name", user.getName(), true);
            avatarEmber.addField("Online status: ", e.getGuild().getMembersByName(userName, true).get(0).getOnlineStatus().toString(), true);
            // avatarEmber.addField("Avatar: ", "The Avatar is below, " + e.getMember().getAsMention(), true);
            avatarEmber.setImage(avatar);
            avatarEmber.setFooter(String.format("Request was made @ " + formatter, date), e.getGuild().getIconUrl());

            e.getChannel().sendMessage(avatarEmber.build()).queue();
        }

    }
}
