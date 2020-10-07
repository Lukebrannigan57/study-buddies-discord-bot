package com.studybuddies.discordbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:discordbot.properties")
public class DiscordBotConfig {

    // @Value will get values from application.properties
    @Value("${discord.bot.token}")
    private String discordBotToken;

    // "!sb " is just the default value to use if custom prefix is not set
    @Value("${discord.bot.prefix:!sb }")
    private String discordCommandPrefix;

    @Value("${discord.bot.owner:A Very Cool Person!}")
    private String discordBotOwner;

    public String getDiscordBotToken() {
        return discordBotToken;
    }

    public String getDiscordCommandPrefix() {
        return discordCommandPrefix;
    }

    public String getDiscordBotOwner() {
        return discordBotOwner;
    }
}
