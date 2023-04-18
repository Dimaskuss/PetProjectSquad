package best.team.petprojectsquad.service;

import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CatShelterInfoServiceTest {

    @Mock
    CatShelterInfoService catShelterInfoService;

    @Test
    void getReplyMessageAddress() {
        Long id = 1005223990L;
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "а сейчас должна появиться информация о боте по команде /info!");
        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/img_1.png"));
        requestArrayList.add(sendMessage);
        requestArrayList.add(sendPhoto);
        when(catShelterInfoService.getReplyMessage(1005223990L, "/address")).thenReturn(requestArrayList);
        assertEquals(catShelterInfoService.getReplyMessage(1005223990L, "/address"), requestArrayList);
    } @Test
    void getReplyMessageAdmissionRules() {
        Long id = 1005223990L;
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "а сейчас должна появиться информация о боте по команде /info!");
        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/img_1.png"));
        requestArrayList.add(sendMessage);
        requestArrayList.add(sendPhoto);
        when(catShelterInfoService.getReplyMessage(1005223990L, "/admissionRules")).thenReturn(requestArrayList);
        assertEquals(catShelterInfoService.getReplyMessage(1005223990L, "/admissionRules"), requestArrayList);
    } @Test
    void getReplyMessageWorkSchedule() {
        Long id = 1005223990L;
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "а сейчас должна появиться информация о боте по команде /info!");
        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/img_1.png"));
        requestArrayList.add(sendMessage);
        requestArrayList.add(sendPhoto);
        when(catShelterInfoService.getReplyMessage(1005223990L, "/workSchedule")).thenReturn(requestArrayList);
        assertEquals(catShelterInfoService.getReplyMessage(1005223990L, "/workSchedule"), requestArrayList);
    }

    @Test
    void getReplyMessageInsideRules() {
        Long id = 1005223990L;
        List<BaseRequest> requestArrayList = new ArrayList<>();
        SendMessage sendMessage = new SendMessage(id, "а сейчас должна появиться информация о боте по команде /info!");
        SendPhoto sendPhoto = new SendPhoto(id, new File("src/main/resources/img_1.png"));
        requestArrayList.add(sendMessage);
        requestArrayList.add(sendPhoto);
        when(catShelterInfoService.getReplyMessage(1005223990L, "/insideRules")).thenReturn(requestArrayList);
        assertEquals(catShelterInfoService.getReplyMessage(1005223990L, "/insideRules"), requestArrayList);
    }
}