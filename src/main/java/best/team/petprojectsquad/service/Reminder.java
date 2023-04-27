package best.team.petprojectsquad.service;

import com.pengrad.telegrambot.request.SendMessage;

public interface Reminder {
    void sendReminderForUser(SendMessage sendMessage);
}
