package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Cat;
import best.team.petprojectsquad.repository.CatRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/Cats")
public class CatController {
    private final CatRepository catRepository;

    @Operation(
            summary = "Getting cat by it's id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Cat in database with id",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Cat.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "There is no cat under that id!"
                    )
            }, tags = "Cat"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<Cat> getCatById(@Parameter(description = "id of a cat in a DB", example = "1") @PathVariable long id) {
        return ResponseEntity.ok(catRepository.getReferenceById(id));
    }

    @Operation(
            summary = "Adding cat, returning id of added cat",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Cat has been added to database successfully!"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Some fields may be empty, try to fill them correctly using example"
                    )
            }, tags = "Cat"
    )
    @PostMapping("/")
    public ResponseEntity<Long> addCat(@Parameter (description = "an Entity 'cat' in database") @RequestBody Cat cat) {
        return ResponseEntity.ok().body(catRepository.save(cat).getId());
    }

    @Operation(
            summary = "Editing cat",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Cat has been successfully edited, id has been successfully returned"
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "There is no cat in database by this id"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Some fields in body may be empty, or may contain irrelevant type! Try to fill fields correctly using example"
                    )
            }, tags = "Cat"
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> editCat(@Parameter(description = "id of a cat in a DB", example = "1") @PathVariable long id, @Parameter(description = "an Entity 'cat' in database") @RequestBody Cat cat) {
        if (catRepository.findById(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        catRepository.deleteById(id);
        catRepository.save(cat);
        return ResponseEntity.ok().body(cat.getId());
    }

    @Operation(
            summary = "Getting all cats",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Cats has been returned successfully",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = Cat[].class)
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "Cat database is empty"
                    )
            }, tags = "Cat"
    )
    @GetMapping("/getAll")
    public ResponseEntity<List<Cat>> getAll() {
        if (catRepository.findAll().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(catRepository.findAll());
    }


    @Operation(
            summary = "Deleting cat by it's id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Cat has been Successfully removed"
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "There is no cat in database by this id"
                    )
            }, tags = "Cat"
    )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCat(@Parameter @PathVariable long id) {
        if (catRepository.findById(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        catRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
