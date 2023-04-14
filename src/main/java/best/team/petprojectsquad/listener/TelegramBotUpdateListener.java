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
                /*
                метод handleUpdate -> принимает Update который прилетел из телефона
                update содержит данные пользователя кто отправил запрос на сервер (нам),
                а так же может содержать  текст, фото, аудио, callbackQuery(сигнал от нажатой кнопки) и т.д.
                 метод handleUpdate -> возвращает List<BaseRequest> - это список исходящих сообщений
                который может содержать объекты SendMessage SendPhoto и т.д все что мы захотим добавить
                 в строчке ниже в цикле forEach мы по очереди отправляем все сообщения добаленные в List
                 */
                mainHandler.handleUpdate(update).stream().forEach(message -> telegramBot.execute(message));

            });
        } catch (Exception e) {
            //это логгер который отправляет нам сообщения в консоль
            //работает так как в пропертис определен его статус logging.level.root=info
            // а над классом стоит аннотация @Slf4j
            // в дальнейшем сделаем чтоб логи писались в файл
            log.error(e.getMessage());
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }


}