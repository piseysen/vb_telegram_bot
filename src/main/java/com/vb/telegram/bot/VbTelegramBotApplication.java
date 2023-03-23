package com.vb.telegram.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class VbTelegramBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(VbTelegramBotApplication.class, args);

        TelegramBotsApi botsApi = null;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot());

            Bot bot = new Bot();
            //bot.sendText(439234881L, "Welcome to Vattanac Bank Telegram Bot. This message sent from Spring boot API.");
            //bot.sendText(636774093L, "Welcome to Vattanac Bank Telegram Bot. This message sent from Spring boot API.");
//            bot.sendText(-915940139L, "Hello I am chat bot.");
//            bot.sendText(-1001831171497L, "Hello everyone in IT App Family, I am chat bot, thanks.");
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}
