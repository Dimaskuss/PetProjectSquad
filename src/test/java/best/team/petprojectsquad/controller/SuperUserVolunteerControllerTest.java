package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.SuperUserVolunteer;
import best.team.petprojectsquad.service.controllerService.SuperUserVolunteerControllerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


    @ExtendWith(MockitoExtension.class)
    class SuperUserVolunteerControllerTest {
        @Mock
        SuperUserVolunteerControllerService superUserVolunteerControllerService;

        @InjectMocks
        private SuperUserVolunteerController superUserVolunteerController;

        private SuperUserVolunteer superUserVolunteer = new SuperUserVolunteer(0L, null, 0);
        private Long id = 0L;

        @Test
        void shouldReturnRightObjectPassIdGetter() {

            when(superUserVolunteerControllerService.getReferenceById(id)).thenReturn(superUserVolunteer);

            ResponseEntity<SuperUserVolunteer> status = superUserVolunteerController.getUserById(0);

            assertEquals(status.getBody(), superUserVolunteer);
        }

        @Test
        void shouldReturnRightObjectPassAdd() {

            when(superUserVolunteerControllerService.save(superUserVolunteer)).thenReturn(id);
            ResponseEntity<Long> idNewUserCat = superUserVolunteerController.addUser(superUserVolunteer);
            assertEquals(idNewUserCat.getBody(), id);
        }

        @Test
        void shouldReturnRightObjectDelete() {

            when(superUserVolunteerControllerService.save(superUserVolunteer)).thenReturn(id);
            when(superUserVolunteerControllerService.findById(id)).thenReturn(Optional.of(superUserVolunteer));
            ResponseEntity<Long> idEditUserCat = superUserVolunteerController.editUser(id, superUserVolunteer);

        }


    }