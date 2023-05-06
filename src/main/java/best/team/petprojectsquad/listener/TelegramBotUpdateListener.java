package best.team.petprojectsquad.listener;

import best.team.petprojectsquad.handler.MainHandler;
import best.team.petprojectsquad.service.ReminderImpl;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class TelegramBotUpdateListener implements UpdatesListener {

    private final TelegramBot telegramBot;
    private final MainHandler mainHandler;
    private final ReminderImpl reminder;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        try {
            updates.forEach(update -> {
                mainHandler.handleUpdate(update).stream().forEach(message -> telegramBot.execute(message));
            });
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    @Scheduled(cron = "0 0 20 * * *")
    public void mentionForUserToSendReport() {
        List<Long> ids = reminder.idUserToSendReminder();
        if (!ids.isEmpty()) {
            ids.forEach(id -> telegramBot.execute(new SendMessage(id, """
                    С момента отправки последнего отчета прошло более одного дня
                    , поэтому не забудьте отправить отчет в ближайшее время."
                    """)));
        }
    }
}