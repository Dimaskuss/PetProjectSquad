package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.SuperUserVolunteer;
import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.service.controllerService.SuperUserVolunteerControllerService;
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
@RequestMapping("/superUser")
@AllArgsConstructor
@Tag(name = "SuperUserVolunteer", description = "Any user, which control any UserDog or UserCat")
public class SuperUserVolunteerController  {
    private final SuperUserVolunteerControllerService superUserVolunteerControllerService;

    @Operation(
            summary = "Getting SuperUserVolunteer by it's id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "SuperUserVolunteer in database with id",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = User.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "There is no SuperUserVolunteer under that id!"
                    )
            }, tags = "SuperUserVolunteer"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<SuperUserVolunteer> getUserById(@Parameter(description = "id of a SuperUserVolunteer in a DB", example = "1") @PathVariable long id) {
        return ResponseEntity.ok(superUserVolunteerControllerService.getReferenceById(id));
    }

    @Operation(
            summary = "Adding user, returning id of added user",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User has been added to database successfully!"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Some fields may be empty, try to fill them correctly using example"
                    )
            }, tags = "User"
    )
    @PostMapping("/")
    public ResponseEntity<Long> addUser(@Parameter (description = "An Entity 'user' in database") @RequestBody SuperUserVolunteer user) {
        return ResponseEntity.ok().body(superUserVolunteerControllerService.save(user));
    }

    @Operation(
            summary = "Editing user",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "SuperUserVolunteer has been successfully edited, id has been successfully returned"
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "There is no SuperUserVolunteer in database by this id"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Some fields in body may be empty, or may contain irrelevant type! Try to fill fields correctly using example"
                    )
            }, tags = "SuperUserVolunteer"
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> editUser(@Parameter(description = "id of a SuperUserVolunteer in a DB", example = "1") @PathVariable long id, @Parameter(description = "an Entity 'SuperUserVolunteer' in database") @RequestBody SuperUserVolunteer user) {
        if (superUserVolunteerControllerService.findById(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        superUserVolunteerControllerService.deleteById(id);
        superUserVolunteerControllerService.save(user);
        return ResponseEntity.ok().body(user.getId());
    }

    @Operation(
            summary = "Getting all SuperUserVolunteers",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "SuperUserVolunteers has been returned successfully",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = User[].class)
                                    )
                            )
                    )
            }, tags = "SuperUserVolunteer"
    )
    @GetMapping("/")
    public ResponseEntity<List<SuperUserVolunteer>> getAll() {
        return ResponseEntity.ok().body(superUserVolunteerControllerService.findAll());
    }


    @Operation(
            summary = "Deleting SuperUserVolunteer by it's id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "SuperUserVolunteer has been Successfully removed"
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "There is no SuperUserVolunteer in database by this id"
                    )
            }, tags = "SuperUserVolunteer"
    )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@Parameter @PathVariable long id) {
        if (superUserVolunteerControllerService.findById(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        superUserVolunteerControllerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}