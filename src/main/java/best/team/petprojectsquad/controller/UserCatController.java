package best.team.petprojectsquad.controller;


import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.service.RepositoryService;
import best.team.petprojectsquad.service.controllerService.UserCatControllerService;
import best.team.petprojectsquad.service.controllerServiceImpl.UserCatControllerServiceImpl;
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
@RequestMapping(value = "/UserCat")
@Tag(name = "UserCat", description = "Api for working with new pet owners")
public class UserCatController {
    private final UserCatControllerService controllerService;
    private final RepositoryService<UserCat> repository;

    @Operation(summary = "Getting user by id")
    @ApiResponse(
            responseCode = "200",
            description = "User in database with id",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = UserCat.class))
    )
    @ApiResponse(
            responseCode = "500",
            description = "There is no user under that id!"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserCat> getUserById(@Parameter(description = "id of a user in a DB", example = "1")
                                               @PathVariable long id) {
        return ResponseEntity.ok(repository.get(id).get());
    }

    @Operation(summary = "Adding cat user, returning id of added user")
    @ApiResponse(
            responseCode = "200",
            description = "User has been added to database successfully!"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Some fields may be empty or may contain irrelevant type! Or there is no Entity by this id in DB"
    )
    @ApiResponse(
            responseCode = "500",
            description = "Cat by this id has been taken"
    )
    @PostMapping("/id{id}catId{catId}")
    public ResponseEntity<Long> addUserCat(@Parameter(description = "id of a cat in a cat.DB", example = "1")
                                           @PathVariable long catId,
                                           @Parameter(description = "id of a user in a user.DB", example = "1")
                                           @PathVariable long id,
                                           @Parameter(description = "An Entity 'userCat' in database")
                                           @RequestBody UserCat userCat) {
        if (controllerService.checkIfEntitiesExist(id, catId)) {
            return ResponseEntity.ok().body(controllerService.save(catId, id, userCat));
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "Editing user")
    @ApiResponse(
            responseCode = "200",
            description = "user has been successfully edited, id has been successfully returned"
    )
    @ApiResponse(
            responseCode = "204",
            description = "There is no user in database by this id"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Some fields in body may be empty, or may contain irrelevant type! Try to fill fields correctly using example"
    )
    @PutMapping(value = "/id{id}{catId}")
    public ResponseEntity<Long> editUser(@Parameter(description = "id of a cat in a cat.DB", example = "1")
                                         @PathVariable long catId,
                                         @Parameter(description = "id of a cat in a cat.DB", example = "1")
                                         @PathVariable long id,
                                         @Parameter(description = "an Entity 'userCat' in database")
                                         @RequestBody UserCat userCat) {
        if (controllerService.checkIfEntitiesExist(id, catId)) {
            repository.delete(userCat.getId());
            controllerService.save(catId, id, userCat);
            return ResponseEntity.ok().body(userCat.getId());
        }
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Getting all users")
                    @ApiResponse(
                            responseCode = "200",
                            description = "Users has been returned successfully",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = UserCat[].class)))
                    )
    @GetMapping("/")
    public ResponseEntity<List<UserCat>> getAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @Operation(summary = "Deleting user by it's id")
                    @ApiResponse(
                            responseCode = "200",
                            description = "User has been Successfully removed"
                    )
                    @ApiResponse(
                            responseCode = "204",
                            description = "There is no user in database by this id"
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
