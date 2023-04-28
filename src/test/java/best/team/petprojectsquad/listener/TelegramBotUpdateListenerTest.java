package best.team.petprojectsquad.listener;

import best.team.petprojectsquad.handler.MainHandler;
import best.team.petprojectsquad.service.ReminderImpl;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TelegramBotUpdateListenerTest {
    @Mock
    private TelegramBot telegramBot;
    @Mock
    private MainHandler mainHandler;
    @InjectMocks
    private TelegramBotUpdateListener telegramBotUpdateListener;
    @Mock
    private ReminderImpl reminder;

    @Test
    public void handleStartTest() throws URISyntaxException, IOException {
        String json = Files.readString(Path.of(
                (TelegramBotUpdateListenerTest.class.getResource("update.json")).toURI()));
        Update update = BotUtils.fromJson(json.replace("%text%", "/start"), Update.class);
        List<BaseRequest> baseRequestList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(123L, "Выберите интересующий Вас приют:");
        baseRequestList.add(sendMessage);
        when(mainHandler.handleUpdate(update)).thenReturn(baseRequestList);

        telegramBotUpdateListener.process(Collections.singletonList(update));

//        ArgumentCaptor<SendPhoto> argumentCaptorPhoto = ArgumentCaptor.forClass(SendPhoto.class);
        ArgumentCaptor<SendMessage> argumentCaptorMessage = ArgumentCaptor.forClass(SendMessage.class);
//        Mockito.verify(telegramBot).execute(argumentCaptorPhoto.capture());
        Mockito.verify(telegramBot).execute(argumentCaptorMessage.capture());
        SendMessage actualMessage = argumentCaptorMessage.getValue();
//        SendPhoto actualPhoto = argumentCaptorPhoto.getValue();

        Assertions.assertThat(actualMessage.getParameters().get("chat_id")).isEqualTo(update.message().chat().id());
        Assertions.assertThat(actualMessage.getParameters().get("text")).isEqualTo("Выберите интересующий Вас приют:");
//        Assertions.assertThat(actualPhoto.getParameters().get("photo")).isEqualTo("src/main/resources/mainMenu.png");

    }

    /*@Test
    public void mentionForUserToSendReport() {

    }*/
}
