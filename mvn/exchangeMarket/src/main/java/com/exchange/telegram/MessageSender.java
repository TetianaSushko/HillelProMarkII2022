package com.exchange.telegram;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.logging.Logger;

@Service
public class MessageSender extends TelegramLongPollingBot {

    Logger logger = Logger.getLogger(MessageSender.class.getName());

    @Value("${telegram.bot.username}")
    private String username;

    @Value("${telegram.bot.token}")
    private String token;

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                logger.info("-> " + message.getText());
              SendMessage sm = new SendMessage();

                sm.setText("Ваш ход ..." + String.valueOf(message.getChatId()));
                sm.setChatId(String.valueOf(message.getChatId()));
                execute(sm);
            }
        }
    }
}
