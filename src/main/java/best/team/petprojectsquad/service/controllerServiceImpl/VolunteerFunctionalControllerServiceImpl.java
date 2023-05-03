package best.team.petprojectsquad.service.controllerServiceImpl;

import best.team.petprojectsquad.entity.ShelterTypeOfTable;
import best.team.petprojectsquad.entity.StatusOfDecision;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.UserCatRepository;
import best.team.petprojectsquad.repository.UserDogRepository;
import best.team.petprojectsquad.repository.UserRepository;
import best.team.petprojectsquad.service.controllerService.VolunteerFunctionalControllerService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VolunteerFunctionalControllerServiceImpl implements VolunteerFunctionalControllerService {
    private final UserRepository userRepository;

    private final UserCatRepository userCatRepository;

    private final UserDogRepository userDogRepository;
    TelegramBot telegramBot;

    @Override
    public SendResponse sendRemark(long id) {
        long chatId = userRepository.getReferenceById(id).getChatId();
        SendMessage sendMessage = new SendMessage(chatId, "Дорогой усыновитель, мы заметили, что ты заполняешь отчет не так подробно, как необходимо. Пожалуйста, " +
                                                          "подойди ответственнее к этому занятию. В противном случае волонтеры приюта будут обязаны самолично " +
                                                          "проверять условия содержания животного");
        return telegramBot.execute(sendMessage);
    }

    @Override
    public SendResponse sendDecision(long id, StatusOfDecision status, ShelterTypeOfTable type) {
        //TODO: завести специальное поле с репозиторием
        SendMessage sendMessage;
        if (type.getShelterTypeInString().equals("DOG")) {
            long chatId = userDogRepository.getReferenceById(id).getChatId();
            UserDog referenceById;
            switch (status) {
                case SUCCESSFULLY_PASSED -> {
                    sendMessage = new SendMessage(chatId, "Дорогой усыновитель, вы отлично прошли проверку!");
                    referenceById = userDogRepository.getReferenceById(id);
                    userDogRepository.deleteById(id);
                    referenceById.setStatus(status.getState());
                    userDogRepository.save(referenceById);
                }
                case EXTENSION_FOR_30_DAYS -> {
                    sendMessage = new SendMessage(chatId, "Дорогой усыновитель, мы заметили, что ты заполняешь отчет не так подробно, как необходимо. Поэтому мы продлеваем " +
                                                          "твой испытательный срок на 30 дней!");
                    referenceById = userDogRepository.getReferenceById(id);
                    userDogRepository.deleteById(id);
                    referenceById.setStatus(status.getState());
                    userDogRepository.save(referenceById);
                }
                case EXTENSION_FOR_14_DAYS -> {
                    sendMessage = new SendMessage(chatId, "Дорогой усыновитель, мы заметили, что ты заполняешь отчет не так подробно, как необходимо. Поэтому мы продлеваем " +
                                                          "твой испытательный срок на 14 дней!");
                    referenceById = userDogRepository.getReferenceById(id);
                    userDogRepository.deleteById(id);
                    referenceById.setStatus(status.getState());
                    userDogRepository.save(referenceById);
                }
                case NOT_PASSED -> {
                    sendMessage = new SendMessage(chatId, "Дорогой усыновитель, мы заметили, что ты заполняешь отчет не так подробно, как необходимо. Что-то пошло не так " +
                                                          ", поэтому мы вынуждены изъять у тебя животного");
                    referenceById = userDogRepository.getReferenceById(id);
                    userDogRepository.deleteById(id);
                    referenceById.setStatus(status.getState());
                    userDogRepository.save(referenceById);
                }
                default -> sendMessage = new SendMessage(chatId, "");
            }
        } else {
            UserCat userCat;
            long chatId = userCatRepository.getReferenceById(id).getChatId();
            switch (status) {
                case SUCCESSFULLY_PASSED -> {

                    //TODO: возможно сделать поле с номером телефона для обратной связи
                    sendMessage = new SendMessage(chatId, "Дорогой усыновитель, вы отлично прошли проверку, с чем мы вас поздравляем!!");
                    userCat = userCatRepository.getReferenceById(id);
                    userCatRepository.deleteById(id);
                    userCat.setStatus(status.getState());
                    userCatRepository.save(userCat);
                }
                case EXTENSION_FOR_30_DAYS -> {
                    sendMessage = new SendMessage(chatId, "Дорогой усыновитель, мы заметили, что ты заполняешь отчет не так подробно, как необходимо. Поэтому мы продлеваем " +
                                                          "твой испытательный срок на 30 дней!");
                    userCat = userCatRepository.getReferenceById(id);
                    userCatRepository.deleteById(id);
                    userCat.setStatus(status.getState());
                    userCatRepository.save(userCat);
                }
                case EXTENSION_FOR_14_DAYS -> {
                    sendMessage = new SendMessage(chatId, "Дорогой усыновитель, мы заметили, что ты заполняешь отчет не так подробно, как необходимо. Поэтому мы продлеваем " +
                                                          "твой испытательный срок на 14 дней!");
                    userCat = userCatRepository.getReferenceById(id);
                    userCatRepository.deleteById(id);
                    userCat.setStatus(status.getState());
                    userCatRepository.save(userCat);
                }
                case NOT_PASSED -> {
                    sendMessage = new SendMessage(chatId, "Дорогой усыновитель, мы заметили, что ты заполняешь отчет не так подробно, как необходимо. Что-то пошло не так " +
                                                          ", поэтому мы вынуждены изъять у тебя животного");
                    userCat = userCatRepository.getReferenceById(id);
                    userCatRepository.deleteById(id);
                    userCat.setStatus(status.getState());
                    userCatRepository.save(userCat);
                }
                default -> sendMessage = new SendMessage(chatId, "");
            }
        }
        return telegramBot.execute(sendMessage);
    }

    @Override
    public List<String> getListOfCatAndDogUsers() {
        List<String> listOfUsers = new ArrayList<>();
        List<UserCat> listOfCatUsers = new ArrayList<>();
        List<UserDog> listOfDogUsers = new ArrayList<>();
        for (UserCat userCat : userCatRepository.findAll()) {
            if (userCat.getTrialPeriod() <= 0) {
                listOfCatUsers.add(userCat);
            }
        }
        for (UserDog userDog : userDogRepository.findAll()) {
            if (userDog.getTrialPeriod() <= 0) {
                listOfDogUsers.add(userDog);
            }
        }
        listOfUsers.add("Dog Users: " + listOfDogUsers.toString());
        listOfUsers.add("Cat Users: " + listOfCatUsers.toString());
        return listOfUsers;
    }

    @Override
    public StatusOfDecision getEnumTypeOfDecision(String decision) {
        StatusOfDecision status = switch (decision) {
            case "EXTENSION_FOR_14_DAYS" -> StatusOfDecision.EXTENSION_FOR_14_DAYS;
            case "EXTENSION_FOR_30_DAYS" -> StatusOfDecision.EXTENSION_FOR_30_DAYS;
            case "SUCCESSFULLY_PASSED" -> StatusOfDecision.SUCCESSFULLY_PASSED;
            case "NOT_PASSED" -> StatusOfDecision.NOT_PASSED;
            default -> null;
        };
        return status;
    }

    @Override
    public ShelterTypeOfTable getEnumTypeOfShelter(String decision) {
        ShelterTypeOfTable shelterTypeOfTable = switch (decision) {
            case "DOG" -> ShelterTypeOfTable.DOG_SHELTER;
            case "CAT" -> ShelterTypeOfTable.CAT_SHELTER;
            default -> null;
        };
        return shelterTypeOfTable;
    }
}

//TODO: Добавить инструкции по дальнейшим шагам( что можно сделать ).
