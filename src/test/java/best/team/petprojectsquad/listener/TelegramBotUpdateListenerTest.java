package best.team.petprojectsquad.listener;

import best.team.petprojectsquad.handler.MainHandler;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class TelegramBotUpdateListenerTest {
    @Mock
    private TelegramBot telegramBot;
    @Mock
    private MainHandler mainHandler;
    @InjectMocks
    private TelegramBotUpdateListener telegramBotUpdateListener;

    @Test
    public void handleStartTest() throws URISyntaxException, IOException {
        String json = Files.readString(Path.of(
                (TelegramBotUpdateListenerTest.class.getResource("update.json")).toURI()));
        Update update = BotUtils.fromJson(json.replace("%text%", "/start"), Update.class);

        telegramBotUpdateListener.process(Collections.singletonList(update));

        ArgumentCaptor<SendMessage> argumentCaptorMessage = ArgumentCaptor.forClass(SendMessage.class);
        ArgumentCaptor<SendPhoto> argumentCaptorPhoto = ArgumentCaptor.forClass(SendPhoto.class);
        Mockito.verify(telegramBot).execute(argumentCaptorPhoto.capture());
        Mockito.verify(telegramBot).execute(argumentCaptorMessage.capture());
        SendMessage actualMessage = argumentCaptorMessage.getValue();
        SendPhoto actualPhoto = argumentCaptorPhoto.getValue();

        Assertions.assertThat(actualMessage.getParameters().get("chat_id")).isEqualTo(update.message().chat().id());
        Assertions.assertThat(actualMessage.getParameters().get("text")).isEqualTo("Выберите интересующий Вас приют:");

    }
}
