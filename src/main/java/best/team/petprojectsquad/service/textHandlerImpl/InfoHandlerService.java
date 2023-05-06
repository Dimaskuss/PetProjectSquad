package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.service.TextHandlerService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class InfoHandlerService implements TextHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(Message message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(message.chat().id(), "а сейчас должна появиться информация о боте по команде /info!");
        SendPhoto sendPhoto = new SendPhoto(message.chat().id(), new File("src/main/resources/img_1.png"));
        requestArrayList.add(sendMessage);
        requestArrayList.add(sendPhoto);

        return requestArrayList;
    }
}
