package best.team.petprojectsquad.handler.textHandlerImpl;

import best.team.petprojectsquad.listener.TelegramBotUpdateListenerTest;
import best.team.petprojectsquad.service.textHandlerImpl.ReportValidateDogService;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportValidateDogTest {

    @Mock
    private ReportValidateDogService service;
    @InjectMocks
    private ReportValidateDog handler;

    @Test
    void shouldReturnMessageHandle() throws URISyntaxException, IOException {
        List<BaseRequest> expectedArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(123, "Подпись отсутствует, пришлите фото с подписью для отчета.");
        expectedArrayList.add(sendMessage);

        String json = Files.readString(Path.of(
                (TelegramBotUpdateListenerTest.class.getResource("update.json")).toURI()));
        Update update = BotUtils.fromJson(json.replace("%text%", ""), Update.class);

        when(service.getReplyMessage(update.message())).thenReturn(expectedArrayList);

        List<BaseRequest> actualList = handler.handle(update.message());

        assertEquals(actualList.size(), expectedArrayList.size());
        assertEquals(actualList.get(0).getParameters(), expectedArrayList.get(0).getParameters());
    }

}