package com.studybuddies.discordbot;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.studybuddies.discordbot.config.DiscordBotConfig;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;


/*
    CommandLineRunner is a Spring boot interface used to run code in the implementing class,
        before Spring boot run() is finished

     So this is good for loading configuration data and setting up things before Application fully starts

     for more details: https://jhooq.com/commandlinerunner-spring-boot/
 */

@Component
public class DiscordBotRunner implements CommandLineRunner {

    private static JDA jda;

    private static final Logger logger = LoggerFactory.getLogger(DiscordBotRunner.class);
    private final DiscordBotConfig botConfig;

    @Autowired
    public DiscordBotRunner(DiscordBotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public void run(String ...args){
        logger.info("Building JDA...");

        // building JDA
        try{
            jda = JDABuilder
                    .createDefault(botConfig.getDiscordBotToken())
                    .addEventListeners()
                    .build();
        } catch (LoginException e){
            logger.error("ERROR! Check your configuration details in discordbot.properties");
        }
    }

}
