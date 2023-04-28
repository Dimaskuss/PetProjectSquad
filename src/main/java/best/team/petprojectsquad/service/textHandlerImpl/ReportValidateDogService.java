package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.ReportDog;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.ReportDogRepository;
import best.team.petprojectsquad.repository.UserDogRepository;
import best.team.petprojectsquad.service.TextHandlerService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportValidateDogService implements TextHandlerService {

private final ReportDogRepository reportDogRepository;
private final UserDogRepository userDogRepository;

    @Override
    public List<BaseRequest> getReplyMessage(Message message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        if(message.text()!=null && message.photo()!=null){
            ReportDog reportDog = new ReportDog();
            if(!userDogRepository.existsByChatId(message.chat().id())){
                userDogRepository.save(new UserDog(message.chat().id()));
            }
            reportDog.setUserDog(userDogRepository.findByChatId(message.chat().id()));
            reportDog.setDateReport(LocalDate.from(LocalDateTime.now()));
            reportDog.setReport(message.text());
            reportDog.setPhotoId((message.photo()[message.photo().length-1].fileId()));
            reportDogRepository.save(reportDog);

            SendMessage sendMessage = new SendMessage(message.chat().id(), "Отчет направлен волонтеру на проверку.");
            requestArrayList.add(sendMessage);
        } else if (message.text()!=null && message.photo()==null){
            SendMessage sendMessage = new SendMessage(message.chat().id(), "Фото отсутствует, пришлите фото с подписью для отчета.");
            requestArrayList.add(sendMessage);
        } else {
            SendMessage sendMessage = new SendMessage(message.chat().id(), "Подпись отсутствует, пришлите фото с подписью для отчета.");
            requestArrayList.add(sendMessage);
        }

        return requestArrayList;
    }
}
