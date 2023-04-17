package best.team.petprojectsquad.listener;

import best.team.petprojectsquad.handler.MainHandler;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


import java.util.List;


@Slf4j
@Component
@AllArgsConstructor
public class TelegramBotUpdateListener implements UpdatesListener {

    private final TelegramBot telegramBot;
    private final MainHandler mainHandler;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    public int process(List<Update> updates) {
        try {
            updates.forEach(update -> {

                mainHandler.handleUpdate(update).stream().forEach(message -> telegramBot.execute(message));

            });
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}