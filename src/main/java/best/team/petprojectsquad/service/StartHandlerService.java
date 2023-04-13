package best.team.petprojectsquad.service;

import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Service;

@Service
public class StartHandlerService implements TextHandlerService{

    @Override
    public SendMessage getReplyMessage(Long id, String message) {
        return new SendMessage(id,"сейчас появляется стартовое меню на команду /start!");
    }
}
