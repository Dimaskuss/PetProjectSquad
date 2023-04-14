package best.team.petprojectsquad.service;

import com.pengrad.telegrambot.request.BaseRequest;

import java.util.List;

public interface TextHandlerService {
    /**
     * Формирование ботом ответа пользователю
     *
     * @param id
     * @param message сообщение пользователя
     * @return ответ пользователю, сформированный ботом
     */
    List<BaseRequest> getReplyMessage(Long id, String message);
}
