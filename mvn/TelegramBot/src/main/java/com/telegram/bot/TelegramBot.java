package com.telegram.bot;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TelegramBot extends TelegramLongPollingBot {

    Logger logger = Logger.getLogger(TelegramBot.class.getName());

    @Override
    public String getBotToken() {
        return "5817271358:AAFxFP3tE5r0IVr9sIGjr6rXg63X-zOXaG8";
    }

    @Override
    public String getBotUsername() {
        return "HillelMarketBot";
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                logger.info("-> " + message.getText());
                sendMessage(send(message));
            }
        }
    }

    public void sendMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public SendMessage send(Message message) {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();
        KeyboardRow row1 = new KeyboardRow();
        row1.add("Камень \uD83D\uDC4A️");
        row1.add("Ножницы ✌️");
        row1.add("Бумага \uD83E\uDD1A");
        keyboardRows.add(row1);
        KeyboardRow row2 = new KeyboardRow();
        row2.add("Статистика");
        keyboardRows.add(row2);
        markup.setKeyboard(keyboardRows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Ваш ход ...");
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }
}
