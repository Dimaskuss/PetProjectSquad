package best.team.petprojectsquad.service;

import com.pengrad.telegrambot.request.BaseRequest;

import java.util.List;

public interface TextHandlerService {
    List<BaseRequest> getReplyMessage(long id, String message);
}
