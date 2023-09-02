package com.vb.telegram.bot.controller;

import com.vb.telegram.bot.dto.response.DataResponse;
import com.vb.telegram.bot.dto.response.ResponseMsg;
import com.vb.telegram.bot.helper.Bot;
import com.vb.telegram.bot.dto.Request.PostMessage;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.TelegramBotsApi;
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
            botsApi.registerBot(new Bot(postMessage.getBotUsername(), postMessage.getBotToken()));

            Bot bot = new Bot(postMessage.getBotUsername(), postMessage.getBotToken());
            bot.sendText(postMessage.getChatId(), postMessage.getText());

            return new DataResponse<>(ResponseMsg.responseSuccessful(), null);

        } catch (Exception e) {
            return new DataResponse<>(ResponseMsg.responseError(), null);
        }
    }

}
