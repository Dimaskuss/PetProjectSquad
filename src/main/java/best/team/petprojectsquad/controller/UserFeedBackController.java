package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.UserFeedBack;
import best.team.petprojectsquad.repository.UserFeedBackRepository;
import best.team.petprojectsquad.service.controllerService.UserFeedBackControllerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/UserFeedBack")
@Tag(name = "UserFeedBack", description = "UserFeedback entity in DB")
public class UserFeedBackController {
    UserFeedBackRepository userFeedBack;

    private final UserFeedBackControllerService userFeedBackRepository;

    @Operation(
            summary = "Getting UserFeedBack by it's id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "UserFeedBack in database with id",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = UserFeedBack.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "There is no UserFeedBack under that id!"
                    )
            }, tags = "UserFeedBack"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserFeedBack> getUserById(@Parameter(description = "id of a UserFeedBack in a DB", example = "1") @PathVariable long id) {
        return ResponseEntity.ok(userFeedBackRepository.getReferenceById(id));
    }

    @Operation(summary = "Adding UserFeedBack, returning id of added UserFeedBack")
    @ApiResponse(
            responseCode = "200",
            description = "UserFeedBack has been added to database successfully!"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Some fields may be empty, try to fill them correctly using example"
    )
    @PostMapping("/add")
    public ResponseEntity<Long> addUser(@Parameter(description = "An Entity 'UserFeedBack' in database") @RequestBody UserFeedBack user) {
        return ResponseEntity.ok().body(userFeedBackRepository.save(user));
    }

    @Operation(summary = "Editing UserFeedBack")
    @ApiResponse(
            responseCode = "200",
            description = "UserFeedBack has been successfully edited, id has been successfully returned"
    )
    @ApiResponse(
            responseCode = "204",
            description = "There is no user in database by this id"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Some fields in body may be empty, or may contain irrelevant type! Try to fill fields correctly using example"
    )
    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<Long> editUser(@Parameter(description = "id of a user in a DB", example = "1")
                                         @PathVariable long id,
                                         @Parameter(description = "an Entity 'UserFeedBack' in database")
                                         @RequestBody UserFeedBack user) {
        if (userFeedBackRepository.findById(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        userFeedBackRepository.deleteById(id);
        userFeedBackRepository.save(user);
        return ResponseEntity.ok().body(user.getId());
    }

    @Operation(summary = "Getting all UserFeedBacks")
    @ApiResponse(
            responseCode = "200",
            description = "UserFeedBacks has been returned successfully",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation = UserFeedBack[].class)))
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<UserFeedBack>> getAll() {
        return ResponseEntity.ok().body(userFeedBackRepository.findAll());
    }

    @Operation(summary = "Deleting UserFeedBack by id")
    @ApiResponse(
            responseCode = "200",
            description = "UserFeedBack has been Successfully removed"
    )
    @ApiResponse(
            responseCode = "204",
            description = "There is no user in database by this id"
    )
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteUser(@Parameter(description = "id of a user in a DB", example = "1")
                                           @PathVariable long id) {
        if (userFeedBackRepository.findById(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        userFeedBackRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Editing user's feedback parameter of column")
    @ApiResponse(
            responseCode = "200",
            description = "user has been successfully edited, now there's no need of feedback for user by this id"
    )
    @ApiResponse(
            responseCode = "204",
            description = "There is no user in database by this id"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Some fields in body may be empty, or may contain irrelevant type! Try to fill fields correctly using example"
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> setFalseConditionFeedBack(@Parameter(description = "id of a user in a DB", example = "1")
                                                          @PathVariable long id) {
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
