package com.example.bespo_bot.configuration;

import com.example.bespo_bot.bot.BespoBot;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * @author BespoyasovaV
 */
@Configuration
public class BespoBotConfiguration {


    @Bean
    public TelegramBotsApi telegramBotsApi(BespoBot bespoBot) throws TelegramApiException {
        //регистрация бота
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bespoBot);
        return telegramBotsApi;
    }

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
}
