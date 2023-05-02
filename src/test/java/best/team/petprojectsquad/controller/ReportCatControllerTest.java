package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.service.RepositoryService;
import best.team.petprojectsquad.service.controllerServiceImpl.UserCatControllerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReportCatControllerTest {

    @Mock
    private UserCatControllerServiceImpl userCatControllerService;

    @Mock
    private RepositoryService<ReportCat> reportCatRepository;

    @InjectMocks
    private ReportCatController reportCatController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        objectMapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Test getting user by id - success")
    public void testGetUserByIdSuccess() throws Exception {
        // Arrange
        ReportCat reportCat = new ReportCat();
        reportCat.setId(1L);
        UserCat userCat = new UserCat();
        userCat.setId(1L);
        reportCat.setUserCat(userCat);
        when(reportCatRepository.get(1L)).thenReturn(java.util.Optional.of(reportCat));

        // Act
        ResponseEntity<ReportCat> responseEntity = reportCatController.getUserById(1L);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(objectMapper.writeValueAsString(reportCat), objectMapper.writeValueAsString(responseEntity.getBody()));
    }

    @Test
    @DisplayName("Test getting user by id - failure")
    public void testGetUserByIdFailure() throws Exception {
        // Arrange
        when(reportCatRepository.get(1L)).thenReturn(java.util.Optional.empty());

        // Act
        ResponseEntity<ReportCat> responseEntity = reportCatController.getUserById(1L); //???

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

    @Test
    @DisplayName("Test adding user - success")
    public void testAddUserSuccess() throws Exception {
        // Arrange
        ReportCat reportCat = new ReportCat();
        reportCat.setId(1L);
        UserCat userCat = new UserCat();
        userCat.setId(1L);
        reportCat.setUserCat(userCat);
        when(userCatControllerService.checkIfEntitiesExist(reportCat.getId(), 1L)).thenReturn(true);
        when(userCatControllerService.save(reportCat.getId(), 1L, reportCat.getUserCat())).thenReturn(1L);

        // Act
        ResponseEntity<Long> responseEntity = reportCatController.addUser(1L, reportCat);

        // Assert
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1L, responseEntity.getBody());
    }

    @Test
    @DisplayName("Test adding user - failure")
    public void testAddUserFailure() throws Exception {
        // Arrange
        ReportCat reportCat = new ReportCat();
        reportCat.setId(1L);
        UserCat userCat = new UserCat();
        userCat.setId(1L);
        reportCat.setUserCat(userCat);
        when(userCatControllerService.checkIfEntitiesExist(reportCat.getId(), 1L)).thenReturn(false);

        // Act
        ResponseEntity<Long> responseEntity = reportCatController.addUser(1L, reportCat);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}