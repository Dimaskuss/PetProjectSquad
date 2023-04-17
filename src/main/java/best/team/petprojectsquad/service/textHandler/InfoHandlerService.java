package best.team.petprojectsquad.service.textHandler;

import best.team.petprojectsquad.service.TextHandlerService;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class InfoHandlerService implements TextHandlerService {

    @Override
    public List<BaseRequest> getReplyMessage(long id, String message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "а сейчас должна появиться информация о боте по команде /info!");
        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/img_1.png"));
        requestArrayList.add(sendMessage);
        requestArrayList.add(sendPhoto);

        return requestArrayList;
    }
}
