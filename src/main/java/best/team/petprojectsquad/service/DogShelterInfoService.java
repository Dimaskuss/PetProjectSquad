package best.team.petprojectsquad.service;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DogShelterInfoService implements TextHandlerService {
    // TODO: 16.04.2023 надо перенести в queryService, будет вызываться по кнопке + доработать клавиатуру 
    @Override
    public List<BaseRequest> getReplyMessage(long id, String message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, """
                Могу предоставить некоторую информацию о приюте:
                /address - где он находится
                /workSchedule - как и когда работает
                /admissionRules - какие правила пропуска на территорию приюта
                /insideRules - правила нахождения внутри и общения с животным""");
        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/dog.jpeg"));
        requestArrayList.add(sendMessage);
        requestArrayList.add(sendPhoto);

        return requestArrayList;
    }
}