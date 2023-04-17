package best.team.petprojectsquad.TextMenuHandlerTest;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.textHandler.InfoMenuHandler;
import best.team.petprojectsquad.service.textHandler.InfoHandlerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class InfoHandlerServiceTest {
    private final InfoHandlerService infoHandlerService = new InfoHandlerService();

    private final InfoMenuHandler infoMenuHandler = new InfoMenuHandler(infoHandlerService);

    @Test
    public void shouldReturnInfoWithSlash(){
        assertEquals(infoMenuHandler.getHandlerName(), BotState.INFO);
    }
}
