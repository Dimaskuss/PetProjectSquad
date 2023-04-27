package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.Cache.UserDataCache;
import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.repository.ReportCatRepository;
import best.team.petprojectsquad.repository.UserCatRepository;
import best.team.petprojectsquad.service.QueryHandlerService;
import best.team.petprojectsquad.service.TextHandlerService;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportValidateCatService implements TextHandlerService {

private final ReportCatRepository reportCatRepository;
private final UserCatRepository userCatRepository;

    @Override
    public List<BaseRequest> getReplyMessage(Message message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        if(message.text()!=null && message.photo()!=null){
            ReportCat reportCat = new ReportCat();
            if(!userCatRepository.existsByChatId(message.chat().id())){
                userCatRepository.save(new UserCat(message.chat().id()));
            }
            reportCat.setUserCat(userCatRepository.findByChatId(message.chat().id()));
            //todo: reportCat.setDateReport add new LocalDate now;
            reportCat.setReport(message.text());
            //todo: link photo!?!??
            reportCatRepository.save(reportCat);

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
