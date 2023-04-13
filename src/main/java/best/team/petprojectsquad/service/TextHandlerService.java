package best.team.petprojectsquad.service;

import com.pengrad.telegrambot.request.BaseRequest;

import java.util.List;

public interface TextHandlerService {
    List<BaseRequest> getReplyMessage(Long id, String message);
}
