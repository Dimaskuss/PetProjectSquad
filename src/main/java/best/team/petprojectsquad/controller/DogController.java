package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Dog;
import best.team.petprojectsquad.service.RepositoryService;
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
@RequestMapping(value = "/Dogs")
@Tag(name = "Dog", description = "Dog entity in DB")
public class DogController {

    private final RepositoryService<Dog> repository;

    @Operation(
            summary = "Getting dog by it's id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Dog in database with id",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Dog.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "There is no dog under that id!"
                    )
            }, tags = "Dog"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<Dog> getDogById(@Parameter(description = "id of a dog in a DB", example = "1") @PathVariable long id) {
        return ResponseEntity.ok(repository.get(id).get());
    }

    @Operation(
            summary = "Adding dog, returning id of added dog",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Dog has been added to database successfully!"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Some fields may be empty, try to fill them correctly using example"
                    )
            }, tags = "Dog"
    )
    @PostMapping("/")
    public ResponseEntity<Long> addDog(@Parameter (description = "an Entity 'dog' in database") @RequestBody Dog dog) {
        return ResponseEntity.ok().body(repository.save(dog));
    }

    @Operation(
            summary = "Editing dog",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Dog has been successfully edited, id has been successfully returned"
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "There is no dog in database by this id"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Some fields in body may be empty, or may contain irrelevant type! Try to fill fields correctly using example"
                    )
            }, tags = "Dog"
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> editDog(@Parameter(description = "id of a dog in a DB", example = "1") @PathVariable long id, @Parameter(description = "an Entity 'dog' in database") @RequestBody Dog dog) {
        if (repository.get(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        repository.delete(id);
        repository.save(dog);
        return ResponseEntity.ok().body(dog.getId());
    }

    @Operation(
            summary = "Getting all dogs",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Dogs has been returned successfully",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = Dog[].class)
                                    )
                            )
                    )
            }, tags = "Dog"
    )
    @GetMapping("/")
    public ResponseEntity<List<Dog>> getAll() {
        return ResponseEntity.ok().body(repository.findAll());
    }


    @Operation(
            summary = "Deleting dog by it's id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Dog has been Successfully removed"
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "There is no dog in database by this id"
                    )
            }, tags = "Dog"
    )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteDog(@Parameter @PathVariable long id) {
        if (repository.get(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        repository.get(id);
        return ResponseEntity.ok().build();
    }
}
