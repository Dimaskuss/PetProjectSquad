package best.team.petprojectsquad.config;

import best.team.petprojectsquad.config.BotConfig;
import com.pengrad.telegrambot.TelegramBot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BotConfigTest {
    BotConfig botConfig = new BotConfig();
    @Value("${bot.token}")
    String token;

    @Test
    public void shouldReturnBotTokenOfYours() {
        TelegramBot telegramBot = new TelegramBot(token);
        assertEquals(botConfig.telegramBot(token).getToken(), telegramBot.getToken());
    }
}
