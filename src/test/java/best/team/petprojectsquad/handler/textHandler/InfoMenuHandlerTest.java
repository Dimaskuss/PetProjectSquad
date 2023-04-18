package best.team.petprojectsquad.handler.textHandler;

import best.team.petprojectsquad.entity.BotState;
import best.team.petprojectsquad.handler.MainHandler;
import best.team.petprojectsquad.handler.textHandler.InfoMenuHandler;
import best.team.petprojectsquad.service.textHandler.InfoHandlerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class InfoMenuHandlerTest {

    @Mock
    private InfoHandlerService infoHandlerService;

    private final InfoMenuHandler infoMenuHandler = new InfoMenuHandler(infoHandlerService);

    @Test
    void shouldReturnInfoObject(){
        assertEquals(infoMenuHandler.getHandlerName(), BotState.INFO);
    }

    @Test
    void smth() {
        //infoHandlerService.getReplyMessage();
    }
}
