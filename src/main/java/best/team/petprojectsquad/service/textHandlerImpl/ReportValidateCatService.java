package best.team.petprojectsquad.service.textHandlerImpl;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.repository.ReportCatRepository;
import best.team.petprojectsquad.repository.UserCatRepository;
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
public class ReportValidateCatService implements TextHandlerService {

    private final ReportCatRepository reportCatRepository;
    private final UserCatRepository userCatRepository;

    @Override
    public List<BaseRequest> getReplyMessage(Message message) {
        List<BaseRequest> requestArrayList = new ArrayList<>();

        if (message.caption() != null && message.photo() != null) {
            ReportCat reportCat = new ReportCat();
            if (!userCatRepository.existsByChatId(message.chat().id())) {
                userCatRepository.save(new UserCat(message.chat().id()));
            }
            reportCat.setUserCat(userCatRepository.findByChatId(message.chat().id()));
            reportCat.setDateReport(LocalDate.from(LocalDateTime.now()));
            reportCat.setReport(message.caption());
            reportCat.setPhotoId((message.photo()[message.photo().length - 1].fileId()));
            reportCatRepository.save(reportCat);

            SendMessage sendMessage = new SendMessage(message.chat().id(), "Отчет направлен волонтеру на проверку.");
            requestArrayList.add(sendMessage);
        } else {
            SendMessage sendMessage = new SendMessage(message.chat().id(), "Подпись отсутствует, пришлите фото с подписью для отчета.");
            requestArrayList.add(sendMessage);
        }

        return requestArrayList;
    }
}
