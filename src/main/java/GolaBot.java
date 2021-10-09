import commands.*;
import events.CategoryCreate;
import events.HelloEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

public class GolaBot {

    public static void main(String[] args) throws Exception {
        // Poniżej wprowadzić token naszego bot'a
        JDA jda = JDABuilder.createDefault("").build();

        jda.addEventListener(new HelloEvent());
        jda.addEventListener(new CategoryCreate());
        jda.addEventListener(new Calculate());
        jda.addEventListener(new InviteCommand());
        jda.addEventListener(new UserInfoCommand());
        jda.addEventListener(new ClearChat());

        jda.addEventListener(new Filter());
        jda.addEventListener(new FilterOnOff());
    }
}
