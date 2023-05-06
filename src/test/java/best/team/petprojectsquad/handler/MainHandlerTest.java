package best.team.petprojectsquad.handler;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.listener.TelegramBotUpdateListenerTest;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
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

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MainHandlerTest {
    @Mock
    private BotStateContext botStateContext;
    @Mock
    private UserDataCache userDataCache;
    @InjectMocks
    private MainHandler mainHandler;

    @Test
    void startHandleUpdateTest() throws URISyntaxException, IOException {
        String json = Files.readString(Path.of(
                (TelegramBotUpdateListenerTest.class.getResource("update.json")).toURI()));
        Update update = BotUtils.fromJson(json.replace("%text%", "/start"), Update.class);
        ArgumentCaptor<SendMessage> argumentCaptorMessage = ArgumentCaptor.forClass(SendMessage.class);
        SendMessage actual = argumentCaptorMessage.capture();
        BotState botState = userDataCache.getUsersCurrentBotState(update.message().chat().id());
        SendPhoto sendPhoto = new SendPhoto(update.message().chat().id(), new File("src/main/resources/mainMenu.png"));
        sendPhoto.caption("""
                    Вас приветствует приют для домашних животных.
                    Наш приют содержит бездомных, покалеченных и больных животных (без учёта постоянно прибывающих) и
                    очень нуждается в помощи и благотворительности на постоянной основе. Будем признательны за каждый
                    вклад.
                    Если вы неравнодушны, приезжайте общаться с хвостиками, привезите им вкусняшки, помогите копейкой, 
                    им же немного нужно для счастья. А самое большое счастье для четвероногого друга - обрести свой 
                    родной дом или чью-то родную душу.
                    Мы очень будем рады любой помощи.
                    """);
        List<BaseRequest> baseRequestList = new ArrayList<>();
        baseRequestList.add(sendPhoto);

        when(botStateContext.processInputMessage(botState, update.message())).thenReturn(
                new SendMessage());
// todo Test
        Mockito.verify(botStateContext).processInputMessage(botState, update.message());
        mainHandler.handleInputMessage(update.message());
        Assertions.assertThat(actual.getParameters().get("chat_id")).isEqualTo(update.message().chat().id());
        Assertions.assertThat(actual.getParameters().get("text")).isEqualTo("""
                Вас приветствует приют для домашних животных.
                Наш приют содержит бездомных, покалеченных и больных животных (без учёта постоянно прибывающих) и
                очень нуждается в помощи и благотворительности на постоянной основе. Будем признательны за каждый
                вклад.
                Если вы неравнодушны, приезжайте общаться с хвостиками, привезите им вкусняшки, помогите копейкой, 
                им же немного нужно для счастья. А самое большое счастье для четвероногого друга - обрести свой 
                родной дом или чью-то родную душу.
                Мы очень будем рады любой помощи.""");

    }

    @Test
    void handleInputMessage() {
    }

    @Test
    void handleQueryMessage() {
    }
}