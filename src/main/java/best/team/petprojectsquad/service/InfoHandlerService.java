package best.team.petprojectsquad.service;

import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

@Service
public class InfoHandlerService implements TextHandlerService{

    @Override
    public SendMessage getReplyMessage(Long id, String message) {
        return new SendMessage(id,"а сейчас должна появиться информация о боте по команде /info!");
    }
}
