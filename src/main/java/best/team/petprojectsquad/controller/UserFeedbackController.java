package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/UserFeedBack")
@Tag(name = "User", description = "UserFeedback entity in DB")
public class UserFeedbackController {
    UserFeedBackRepository userFeedBack;

    @Operation(
            summary = "Editing user's feedback parameter of column",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "user has been successfully edited, now there's no need of feedback for user by this id"
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "There is no user in database by this id"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Some fields in body may be empty, or may contain irrelevant type! Try to fill fields correctly using example"
                    )
            }, tags = "UserFeedback"
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> setFalseConditionFeedBack(@Parameter(description = "id of a user in a DB", example = "1") @PathVariable long id) {
        if (userFeedBack.findById(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        UserFeedBack referenceById = userFeedBack.getReferenceById(id);
        userFeedBack.deleteById(id);
        referenceById.setFeedback(false);
        userFeedBack.save(referenceById);
        return ResponseEntity.ok().body(referenceById.getId());
    }
}
