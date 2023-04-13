package best.team.petprojectsquad.service;

import com.pengrad.telegrambot.request.SendMessage;

public interface TextHandlerService {
    SendMessage getReplyMessage(Long id, String message);
}
