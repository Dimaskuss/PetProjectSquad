package best.team.petprojectsquad.service;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class StartHandlerService implements TextHandlerService{

    @Override
    public List<BaseRequest> getReplyMessage(Long id, String message) {
        //создали лист объектов -> исходящее сообщение
        List<BaseRequest> requestArrayList = new ArrayList<>();
        //пример исходящего текстового сообщения
        SendMessage sendMessage = new SendMessage(id, "Первое сообщение меню");
        //пример исходящего сообщения c фоткой, сама фотка в ресурсах лежит
        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/img.png"));
        //пример исходящего текстового сообщения
        SendMessage sendMessage1 = new SendMessage(id,"сейчас появляется стартовое меню на команду /start!");

        //добавили все сообщения в лист
        //дженерик в листе BaseRequest -> от этого класса наследуются и SendMessage и SendPhoto и другие классы
        //исходящих сообщений(хоть аудио добавляй хоть анимацию)
        requestArrayList.add(sendMessage);
        requestArrayList.add(sendPhoto);
        requestArrayList.add(sendMessage1);

        //от сюда наш List<BaseRequest> поледел обратно в TelegramBotUpdateListener
        //где через forEach из него по очереди будут вынуты все сообщения и отправлены
        //пользователю ботом через метод execut()
        return requestArrayList;
    }
}
