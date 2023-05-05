
package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.UserCat;

import best.team.petprojectsquad.service.controllerService.ReportCatControllerService;
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
@RequestMapping(value = "/ReportCat")
@Tag(name = "Report")
public class ReportCatController {
    private final ReportCatControllerService controllerService;

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
    public ResponseEntity<ReportCat> getUserById(@Parameter(description = "id of a user in a DB", example = "1") @PathVariable long id) {
        return ResponseEntity.ok(controllerService.getReferenceById(id));
    }

    @Operation(
            summary = "Adding reportCat, returning id of added report",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Report has been added to database successfully!"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Some fields may be empty or may contain irrelevant type! Or there is no Entity by this id in DB"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "UserCat by this id has been taken"
                    )
            }, tags = "User"
    )
    @PostMapping("/userCatId{userCatId}")
    public ResponseEntity<Long> addUser(@Parameter(description = "id of a userCat in a userCat.DB", example = "1") @PathVariable long userCatId,
                                        @Parameter(description = "An Entity 'user' in database") @RequestBody ReportCat reportCat) {
        return ResponseEntity.ok().body(controllerService.save(reportCat, userCatId));
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
    @PutMapping(value = "/reportId{reportId}")
    public ResponseEntity<Long> editReport(@Parameter(description = "id of a report in report.DB", example = "1") @PathVariable long reportId,
                                           @Parameter(description = "an Entity 'reportCat' in database")
                                           @RequestBody ReportCat reportCat) {
        long ids = controllerService.getReferenceById(reportId).getUserCat().getId();
        controllerService.deleteById(reportId);
        return ResponseEntity.ok().body(controllerService.save(reportCat,ids));
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
    public ResponseEntity<List<ReportCat>> getAll() {
        return ResponseEntity.ok().body(controllerService.findAll());
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
        controllerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

