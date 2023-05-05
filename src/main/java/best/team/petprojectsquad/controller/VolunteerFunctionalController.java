package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.ShelterTypeOfTable;
import best.team.petprojectsquad.entity.StatusOfDecision;
import best.team.petprojectsquad.service.controllerService.VolunteerFunctionalControllerService;
import com.pengrad.telegrambot.response.SendResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Volunteer")
public class VolunteerFunctionalController {
    private final VolunteerFunctionalControllerService volunteerService;

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
    @PostMapping("/{id}")
    public ResponseEntity<SendResponse> sendUserRemarkMessage(@Parameter(description = "id of a user in a user.DB", example = "1")
                                                              @PathVariable long id) {
        return ResponseEntity.ok().body(volunteerService.sendRemark(id));
    }

    @Operation(
            summary = "Sending a comment about final decision to user",
            description = "Choose and write in ShelterTypeOfTable one of these: CAT or DOG. And in StatusOfDecision one of these:  SUCCESSFULLY_PASSED or EXTENSION_FOR_30_DAYS or SUCCESSFULLY_PASSED or NOT_PASSED.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Comment was sent successfully!"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Check fields, read description! Some fields are written wrong!"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "There is no user by this id!"
                    )
            }
    )
    @PostMapping("/decision/id{id}status{status}type{type}")
    public ResponseEntity<SendResponse> sendMessageToUserAboutDecision(@Parameter(description = "id of a user in a user(CAT/DOG).DB", example = "1")
                                                                       @PathVariable long id,
                                                                       @Parameter(description = "Status of decision about user", example = "SUCCESSFULLY_PASSED")
                                                                       @PathVariable String status,
                                                                       @Parameter(description = "Type of shelter", example = "CAT")
                                                                       @PathVariable String type) {
        StatusOfDecision enumStatus = volunteerService.getEnumTypeOfDecision(status);
        ShelterTypeOfTable enumShelter = volunteerService.getEnumTypeOfShelter(type);
        if (enumShelter == null || enumStatus == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(volunteerService.sendDecision(id, enumStatus, enumShelter));
    }

    @Operation(
            summary = "Getting list of users who has successfully pass 30 days of examination or more",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "List has been returned successfully!"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Something went wrong!"
                    )
            }
    )
    @GetMapping("/listOfUsers")
    public ResponseEntity<List<String>> getListOfDogOrCatUsers() {
        return ResponseEntity.ok(volunteerService.getListOfCatAndDogUsers());
    }
}
