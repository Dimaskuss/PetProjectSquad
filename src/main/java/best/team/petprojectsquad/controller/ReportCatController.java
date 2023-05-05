
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
@Tag(name = "Report", description = "Api for working with report on how dog feels in a new place")
public class ReportCatController {

    private final ReportCatControllerService controllerService;

    @Operation(summary = "Getting report by id")
    @ApiResponse(
            responseCode = "200",
            description = "Cat report in database with id",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ReportCat.class))
    )
    @ApiResponse(
            responseCode = "500",
            description = "There is no report under that id!"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<ReportCat> getReportById(@Parameter(description = "id of a user in a DB", example = "1") @PathVariable long id) {
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
    public ResponseEntity<Long> addReport(@Parameter(description = "id of a userCat in a userCat.DB", example = "1") @PathVariable long userCatId,
                                          @Parameter(description = "An Entity 'user' in database") @RequestBody ReportCat reportCat) {
        return ResponseEntity.ok().body(controllerService.save(reportCat, userCatId));

    }

    @Operation(summary = "Editing report")
    @ApiResponse(
            responseCode = "200",
            description = "Report has been successfully edited, id has been successfully returned"
    )

    @PutMapping(value = "/reportId{reportId}")
    public ResponseEntity<Long> editReport(@Parameter(description = "id of a report in report.DB", example = "1") @PathVariable long reportId,
                                           @Parameter(description = "an Entity 'reportCat' in database")
                                           @RequestBody ReportCat reportCat) {
        long ids = controllerService.getReferenceById(reportId).getUserCat().getId();
        controllerService.deleteById(reportId);
        return ResponseEntity.ok().body(controllerService.save(reportCat, ids));
    }

    @Operation(summary = "Getting all reports")
    @ApiResponse(
            responseCode = "200",
            description = "Reports has been returned successfully",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation = ReportCat[].class)))
    )
    @GetMapping("/")
    public ResponseEntity<List<ReportCat>> getAll() {
        return ResponseEntity.ok().body(controllerService.findAll());
    }

    @Operation(summary = "Deleting report by id")
    @ApiResponse(
            responseCode = "200",
            description = "Report has been Successfully removed"
    )
    @ApiResponse(
            responseCode = "204",
            description = "There is no report in database by this id"
    )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteReport(@Parameter(description = "id of a report in report.DB", example = "1")
                                             @PathVariable long id) {
        controllerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

