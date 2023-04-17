package best.team.petprojectsquad.service;

import com.pengrad.telegrambot.request.BaseRequest;

import java.util.List;

public interface QueryHandlerService {
    List<BaseRequest> getReplyMessage(long id);
}
