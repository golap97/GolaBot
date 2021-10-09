package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class HelloEvent extends ListenerAdapter {
    /*
        public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
            String messageSent = event.getMessage().getContentRaw();
            if(messageSent.equalsIgnoreCase("przepraszam")){
                event.getChannel().sendMessage("tekst").queue();
            }
        }

     */
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String[] messageSent = e.getMessage().getContentRaw().split(" ");
        String name = e.getMember().getUser().getName();

        if (messageSent[0].equalsIgnoreCase("przepraszam")) {
            if (!e.getMember().getUser().isBot()) {  //unika nieskonczonej pętli (np messageSent=hi sendMessage=hi);
                //e.getChannel().sendMessage("lol koniara wołaja cię ").queue();
                EmbedBuilder eb = new EmbedBuilder();
                eb.setAuthor("LOL Hippo wołają Cię!");
                eb.setColor(Color.GREEN);
                eb.setImage("http://3.bp.blogspot.com/_eMoSyQZ_tv0/TTtGOa8kB4I/AAAAAAAAABE/lpUIsvmpTgg/s1600/01_hipopotam_noworodekD.jpg");
                e.getChannel().sendMessage(eb.build()).queue();
            }
        } else if (messageSent[0].equalsIgnoreCase("kamilek")) { // kamilek debilek
            if (!e.getMember().getUser().isBot()) {
                e.getChannel().sendMessage(":regional_indicator_d::regional_indicator_e::regional_indicator_b:" +
                        ":regional_indicator_i::regional_indicator_l::regional_indicator_e::regional_indicator_k:").queue();
                EmbedBuilder eb = new EmbedBuilder();
                eb.setAuthor("To jest Kamilek");
                eb.setColor(Color.cyan);
                eb.addField("Sevan", "Warrior", true);
                eb.setThumbnail("http://vignette3.wikia.nocookie.net/wowwiki/images/f/ff/OrcCrest.png/revision/latest?cb=20120913173636");
                eb.setImage("http://faceplantreview.files.wordpress.com/2011/12/crying-peon.jpg");
                e.getChannel().sendMessage(eb.build()).queue();
            }
        } else if (messageSent[0].equalsIgnoreCase("eluwa")) { // witanie sie
            if (!e.getMember().getUser().isBot()) {
                //e.getChannel().sendMessage("elo " + name).queue();
                EmbedBuilder eb = new EmbedBuilder();
                eb.setAuthor("Eluwa " + name);
                eb.setColor(Color.CYAN);
                eb.setImage("https://ocdn.eu/zapytaj/MDA_/824e0e4f-f851-4292-b551-588de583e035.jpeg");
                e.getChannel().sendMessage(eb.build()).queue();
            }
        } else if (messageSent[0].equalsIgnoreCase("pedro")) {
            if (!e.getMember().getUser().isBot()) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setAuthor("Piotruś");
                eb.setColor(Color.orange);
                eb.setImage("https://img.webme.com/vorschau/j/johnnysinsy/5.png");
                e.getChannel().sendMessage(eb.build()).queue();
            }
        } else if (messageSent[0].equalsIgnoreCase("papaj")) {
            if (!e.getMember().getUser().isBot()) {
                EmbedBuilder eb = new EmbedBuilder();
                eb.setAuthor("Papaj");
                eb.setColor(Color.white);
                eb.setImage("https://www.wykop.pl/cdn/c3201142/comment_CaHFxhhY3Zi9cNEaHm0wrBmmVx4Ejj1d.jpg");
                e.getChannel().sendMessage(eb.build()).queue();
            }
        }

    }

}
