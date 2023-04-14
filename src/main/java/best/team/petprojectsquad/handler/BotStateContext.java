package best.team.petprojectsquad.handler;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.textHandler.InputHandlerMessage;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BotStateContext {

    //в этой мапе после запуска программы будут значения:
    // 1) (ключ)BotState.INFO  (значение) infoMenuHandler ->
    // -> объект класса InfoMenuHandler, этот объект спринг создает при запуске автоматически так как класс InfoMenuHandler помечен аннотацией @Component
    // 2) 1) (ключ)BotState.START  (значение) startMenuHandler ->  все аналогично строчке выше
    private final Map<BotState, InputHandlerMessage> messageHandlers = new HashMap<>();


    // это конструктор этого класса BotStateContext
    //по этому при старте программы сприн его обязательно запустит (смотрим наверху на аннотацию @Component)
    //в самом конструкторе мы наполняем мапу выше объектами реализующими интерфейс InputHandlerMessage
    // и infoMenuHandler и startMenuHandler реализуют этот интерфейс, поэтому попадут сюда
    // в интерфейсе есть метод BotState getHandlerName(); с помощью него мы получем значение ключа
    // и как значение ключа уже сам handler
    public BotStateContext(List<InputHandlerMessage> messageHandlers) {
        messageHandlers.forEach(handler -> this.messageHandlers.put(handler.getHandlerName(), handler));
    }

    // сюда нам приходит из MainHandler статус бота и сообщение
    //по статусу из мапы достаем нудный нам handler и передаем туда наше сообщение
    public List<BaseRequest> processInputMessage(BotState currentState, Message message) {
        //в строчке ниже: обработчик входящего запроса = найти обработчик по статусу бота в мапе
        InputHandlerMessage currentMessageHandler = findMessageHandler(currentState);
        //передаем в обработчик уже только сообщение
        return currentMessageHandler.handle(message);
    }

    //вынес этот метод отдельно, тут по статусу бота вытаскиваем из мапы handler по статусу бота
    private InputHandlerMessage findMessageHandler(BotState currentState) {
        return messageHandlers.get(currentState);
    }



}
