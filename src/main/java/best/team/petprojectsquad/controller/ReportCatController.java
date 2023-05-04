
package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.ReportCat;
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
@RequestMapping(value = "/ReportCat")
@Tag(name = "Daily cat report", description = "Api for working with report on how the cat feels in a new place")
public class ReportCatController {

    private final RepositoryService<ReportCat> repositoryReportCat;

    @Operation(summary = "Getting report by id")
    @ApiResponse(
            responseCode = "200",
            description = "Cat report in database with id",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ReportCat.class)
            )
    )
    @ApiResponse(
            responseCode = "500",
            description = "There is no report under that id!"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<ReportCat> getReportById(@Parameter(description = "id of cat report in DB", example = "1")
                                                   @PathVariable long id) {
        return ResponseEntity.ok(repositoryReportCat.get(id).get());
    }

    @Operation(summary = "Adding cat report, returning id of added report")
    @ApiResponse(
            responseCode = "200",
            description = "Report has been added to database successfully!"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Some fields may be empty or may contain irrelevant type!"
    )
    @PostMapping("/")
    public ResponseEntity<Long> addReport(@RequestBody ReportCat reportCat) {
        return ResponseEntity.ok().body(repositoryReportCat.save(reportCat));
    }

    @Operation(summary = "Editing report")
    @ApiResponse(
            responseCode = "200",
            description = "Report has been successfully edited, id has been successfully returned"
    )
    @ApiResponse(
            responseCode = "204",
            description = "There is no report in database by this id"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Some fields may be empty, or there is no Entity by this id in DB"
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> editReport(@Parameter(description = "id of a report in a report.DB", example = "1")
                                           @PathVariable long id,
                                           @Parameter(description = "an Entity 'report' in database")
                                           @RequestBody ReportCat reportCat) {
        if (repositoryReportCat.get(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        repositoryReportCat.delete(id);
        repositoryReportCat.save(reportCat);
        return ResponseEntity.ok().body(reportCat.getId());
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
        return ResponseEntity.ok().body(repositoryReportCat.findAll());
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
    public ResponseEntity<ReportCat> deleteReport(@Parameter(description = "id of a report in a report.DB", example = "1")
                                                  @PathVariable long id) {
        if (repositoryReportCat.get(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        repositoryReportCat.delete(id);
        return ResponseEntity.ok().build();
    }
}

