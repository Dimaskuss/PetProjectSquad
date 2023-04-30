package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.service.RepositoryService;
import best.team.petprojectsquad.service.controllerServiceImpl.UserDogControllerServiceImpl;
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
@RequestMapping(value = "/UserDog")
@Tag(name = "UserDog", description = "a user with dog")
public class UserDogController {
    private final UserDogControllerServiceImpl controllerService;
    private final RepositoryService<UserDog> repository;

    @Operation(
            summary = "Getting user by it's id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User in database with id",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = UserDog.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "There is no user under that id!"
                    )
            }, tags = "User"
    )
    @GetMapping(value = "/{id}")

    public ResponseEntity<UserDog> getUserById(@Parameter(description = "id of a user in a DB", example = "1") @PathVariable long id) {
        return ResponseEntity.ok(repository.get(id).get());
    }

    @Operation(
            summary = "Adding dog user, returning id of added user",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User has been added to database successfully!"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Some fields may be empty or may contain irrelevant type! Or there is no Entity by this id in DB"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Dog by this id has been taken"
                    )
            }, tags = "User"
    )
    @PostMapping("/dogId{dogId}")
    public ResponseEntity<Long> addUser(@Parameter(description = "id of a dog in a dog.DB", example = "1") @PathVariable long dogId, @Parameter(description = "An Entity 'user' in database") @RequestBody UserDog userDog) {
        if (controllerService.checkIfEntitiesExist(userDog.getUserId(), dogId)) {
            return ResponseEntity.ok().body(controllerService.save(userDog, dogId));
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(
            summary = "Editing user",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "user has been successfully edited, id has been successfully returned"
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "There is no user in database by this id"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Some fields may be empty, or there is no Entity bн this id in DB"
                    )
            }, tags = "User"
    )
    @PutMapping(value = "/id{id}/dogId{dogId}")
    public ResponseEntity<Long> editUser(@Parameter(description = "id of a dog in a dog.DB", example = "1") @PathVariable long dogId,
                                         @Parameter(description = "an Entity 'user' in database")
                                         @RequestBody UserDog userDog) {
        if (repository.get(userDog.getUserId()).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        repository.delete(userDog.getUserId());
        controllerService.save(userDog, dogId);
        return ResponseEntity.ok().body(userDog.getId());
    }

    @Operation(
            summary = "Getting all users",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Users has been returned successfully",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = UserDog[].class)
                                    )
                            )
                    )
            }, tags = "User"
    )
    @GetMapping("/")
    public ResponseEntity<List<UserDog>> getAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }


    @Operation(
            summary = "Deleting user by it's id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User has been Successfully removed"
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "There is no user in database by this id"
                    )
            }, tags = "User"
    )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@Parameter @PathVariable long id) {
        if (repository.get(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        repository.delete(id);
        return ResponseEntity.ok().build();
    }
}
