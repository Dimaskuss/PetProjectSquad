package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.listener.TelegramBotUpdateListenerTest;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ValidatePhoneServiceTest {
    @Autowired
    private ValidatePhoneService validatePhoneService;

    private String message = "89356657658";
    private long id = 123;

    @Test
    void getReplyMessage() throws URISyntaxException, IOException {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "Телефон написан некорректно, пришлите еще раз в формате +79315556677");
        requestArrayList.add(sendMessage);

        String json = Files.readString(Path.of(
                (TelegramBotUpdateListenerTest.class.getResource("update.json")).toURI()));
        Update update = BotUtils.fromJson(json.replace("%text%", "test"), Update.class);

        List<BaseRequest> replyMessage = validatePhoneService.getReplyMessage(update.message());
        assertEquals(replyMessage.size(), requestArrayList.size());
        assertEquals(replyMessage.get(0).getParameters(), requestArrayList.get(0).getParameters());
    }
}