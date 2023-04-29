package best.team.petprojectsquad.controller;


import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.service.controllerService.UserCatControllerService;
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
@Tag(name = "UserCat", description = "a user with cat")
public class UserCatController {
    private final UserCatControllerService userCatRepository;

    @Operation(
            summary = "Getting user by it's id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User in database with id",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = UserCat.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "There is no user under that id!"
                    )
            }, tags = "User"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserCat> getUserById(@Parameter(description = "id of a user in a DB", example = "1") @PathVariable long id) {
        return ResponseEntity.ok(userCatRepository.getReferenceById(id));
    }

    @Operation(
            summary = "Adding cat user, returning id of added user",
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
                            description = "Cat by this id has been taken"
                    )
            }, tags = "User"
    )
    @PostMapping("/id{id}/catId{catId}")
    public ResponseEntity<Long> addUser(@Parameter(description = "id of a user in a user.DB", example = "1") @PathVariable long id, @Parameter(description = "id of a cat in a cat.DB", example = "1") @PathVariable long catId, @Parameter(description = "An Entity 'user' in database") @RequestBody UserCat user) {
        if (userCatRepository.checkIfEntitiesExist(id, catId)) {
            return ResponseEntity.ok().body(userCatRepository.save(user, id, catId));
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
                            description = "Some fields in body may be empty, or may contain irrelevant type! Try to fill fields correctly using example"
                    )
            }, tags = "User"
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> editUser(@Parameter(description = "id of a user in a user.DB", example = "1") @PathVariable long id, @Parameter(description = "id of a cat in a cat.DB", example = "1") @PathVariable long catId, @Parameter(description = "an Entity 'user' in database") @RequestBody UserCat user) {
        if (userCatRepository.findById(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        userCatRepository.deleteById(id);
        userCatRepository.save(user, id, catId);
        return ResponseEntity.ok().body(user.getId());
    }

    @Operation(
            summary = "Getting all users",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Users has been returned successfully",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = UserCat[].class)
                                    )
                            )
                    )
            }, tags = "User"
    )
    @GetMapping("/")
    public ResponseEntity<List<UserCat>> getAll() {
        return ResponseEntity.ok().body(userCatRepository.findAll());
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
        if (userCatRepository.findById(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        userCatRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
