package com.vb.telegram.bot.controller;

import com.vb.telegram.bot.dto.response.DataResponse;
import com.vb.telegram.bot.dto.response.ResponseMsg;
import com.vb.telegram.bot.helper.Bot;
import com.vb.telegram.bot.dto.Request.PostMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Created by Pisey Sen
 */

@RestController
@RequestMapping("/api/v1/bot")
public class TestController {

    @PostMapping("/send-message")
    public DataResponse<?> senMessage(@RequestBody PostMessage postMessage){
        TelegramBotsApi botsApi = null;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot());

            Bot bot = new Bot();
            bot.sendText(postMessage.getChatId(), postMessage.getText());

            return new DataResponse<>(ResponseMsg.responseSuccessful(), null);

        } catch (TelegramApiException e) {
            return new DataResponse<>(ResponseMsg.responseError(), null);
        }
    }

}
