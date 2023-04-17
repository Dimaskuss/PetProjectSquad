package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Shelter;
import best.team.petprojectsquad.repository.ShelterRepository;
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
@RequestMapping("/Shelter")
public class ShelterController {
    ShelterRepository ShelterRepository;

    @Operation(
            summary = "Getting Shelter by it's number",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Shelter in database with it's number",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = Shelter.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "There is no Shelter under that number!"
                    )
            }, tags = "Shelter"
    )
    @GetMapping(value = "/{number}")
    public ResponseEntity<Shelter> getShelterById(@Parameter(description = "id of a Shelter in a DB", example = "1") @PathVariable Long number) {
        return ResponseEntity.ok(ShelterRepository.getReferenceById(number));
    }

    @Operation(
            summary = "Adding Shelter, returning number of added Shelter, write value 'number' without char '+'",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Shelter has been added to database successfully!"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Some fields may be empty, try to fill them correctly using example"
                    )
            }, tags = "Shelter"
    )
    @PostMapping("/")
    public ResponseEntity<Long> addShelter(@Parameter (description = "an Entity 'Shelter' in database") @RequestBody Shelter shelter) {
        return ResponseEntity.ok().body(ShelterRepository.save(shelter).getNumber());
    }

    @Operation(
            summary = "Editing Shelter",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Shelter has been successfully edited, number has been successfully returned"
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "There is no Shelter in database by this number"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Some fields in body may be empty, or may contain irrelevant type! Try to fill fields correctly using example"
                    )
            }, tags = "Shelter"
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> editShelter(@Parameter(description = "id of a Shelter in a DB", example = "1") @PathVariable Long id, @Parameter(description = "an Entity 'Shelter' in database") @RequestBody Shelter shelter) {
        if (ShelterRepository.findById(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        ShelterRepository.deleteById(id);
        ShelterRepository.save(shelter);
        return ResponseEntity.ok().body(shelter.getNumber());
    }

    @Operation(
            summary = "Getting all Shelters",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Shelters has been returned successfully",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = Shelter[].class)
                                    )
                            )
                    )
            }, tags = "Shelter"
    )
    @GetMapping("/")
    public ResponseEntity<List<Shelter>> getAll() {
        return ResponseEntity.ok().body(ShelterRepository.findAll());
    }


    @Operation(
            summary = "Deleting Shelter by it's number",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Shelter has been Successfully removed"
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "There is no Shelter in database by this id"
                    )
            }, tags = "Shelter"
    )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteShelter(@Parameter @PathVariable Long id) {
        if (ShelterRepository.findById(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        ShelterRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
