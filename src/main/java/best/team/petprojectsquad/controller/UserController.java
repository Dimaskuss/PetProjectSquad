package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.User;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.repository.UserDogRepository;
import best.team.petprojectsquad.repository.UserRepository;
import best.team.petprojectsquad.service.controllerService.UserCatControllerService;
import best.team.petprojectsquad.service.controllerService.UserControllerService;
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

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Tag(name = "User", description = "Any user, which haven't got any animals")
public class UserController {
    private final UserControllerService userRepository;

    @Operation(
            summary = "Getting user by it's id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "User in database with id",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = User.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "There is no user under that id!"
                    )
            }, tags = "User"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@Parameter(description = "id of a user in a DB", example = "1") @PathVariable long id) {
        return ResponseEntity.ok(userRepository.getReferenceById(id));
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
    public ResponseEntity<Long> addUser(@Parameter (description = "An Entity 'user' in database") @RequestBody User user) {
        return ResponseEntity.ok().body(userRepository.save(user));
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
    public ResponseEntity<Long> editUser(@Parameter(description = "id of a user in a DB", example = "1") @PathVariable long id, @Parameter(description = "an Entity 'user' in database") @RequestBody User user) {
        if (userRepository.findById(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        userRepository.deleteById(id);
        userRepository.save(user);
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
                                    array = @ArraySchema(schema = @Schema(implementation = User[].class)
                                    )
                            )
                    )
            }, tags = "User"
    )
    @GetMapping("/")
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok().body(userRepository.findAll());
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
        if (userRepository.findById(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
