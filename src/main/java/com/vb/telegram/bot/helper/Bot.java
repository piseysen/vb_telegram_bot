package com.vb.telegram.bot.helper;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

/**
 * Created by Pisey Sen
 */

public class Bot extends TelegramLongPollingBot {

    private final String botUsername;
    private final String botToken;
    public Bot(String botUserName, String botToken) {
        this.botUsername = botUserName;
        this.botToken = botToken;
        System.out.println("Bot is running...");
    }

    @Override
    public String getBotUsername() {
        return this.botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }

    private void sendNotification(String chatId, String msg) throws TelegramApiException {
        var response = new SendMessage(chatId, msg);
        execute(response);
    }

    public void sendText(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            //throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        //System.out.println(update);
        if (update.hasMessage()) {
            var msg = update.getMessage();
            var chatId = msg.getChatId();
            System.out.println("chatId" + chatId);
            try {
                var reply = msg.getText().contains("Vattanac") ? "Vattanac Bank is the best bank in Cambodia" : "We will contact you soon, thanks.";
                sendNotification(String.valueOf(chatId), reply);
            } catch (TelegramApiException e) {
               // throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }
}