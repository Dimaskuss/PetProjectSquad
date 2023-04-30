package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.service.controllerService.VolunteerFunctionalControllerService;
import com.pengrad.telegrambot.request.SendMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/Volunteer")
public class VolunteerFunctionalController {
    VolunteerFunctionalControllerService volunteerService;

    @Operation(
            summary = "Sending a comment to the user",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Comment was sent successfully!"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Some error"
                    )
            }
    )
    @PostMapping("/id")
    public ResponseEntity<SendMessage> sendUserRemarkMessage(@Parameter(description = "id of a user in a user.DB", example = "1")
                                        @PathVariable long id) {
        return volunteerService.sendRemark(id);
    }
}
