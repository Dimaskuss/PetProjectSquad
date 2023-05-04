package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.ReportDog;
import best.team.petprojectsquad.entity.UserCat;
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
@RequestMapping(value = "/ReportDog")
@Tag(name = "Daily dog report", description = "Api for working with report on how the cat feels in a new place")
public class ReportDogController {

    private final RepositoryService<ReportDog> repositoryReportDog;

    @Operation(summary = "Getting report by id")
    @ApiResponse(
            responseCode = "200",
            description = "Report in database with id",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ReportDog.class))
    )
    @ApiResponse(
            responseCode = "500",
            description = "There is no report under that id!"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<ReportDog> getReportById(@Parameter(description = "id of a report in a database", example = "1")
                                                   @PathVariable long id) {
        return ResponseEntity.ok(repositoryReportDog.get(id).get());
    }

    @Operation(summary = "Adding report, returning id of added user")
    @ApiResponse(
            responseCode = "200",
            description = "Report has been added to database successfully!"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Some fields may be empty or may contain irrelevant type!"
    )

    @PostMapping("/")
    public ResponseEntity<Long> addReport(@RequestBody ReportDog reportDog) {
        return ResponseEntity.ok().body(repositoryReportDog.save(reportDog));
    }

    @Operation(summary = "Editing report")
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
            description = "Some fields may be empty, or there is no Entity by this id in DB"
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> editReport(@Parameter(description = "id of a report in a report.DB", example = "1")
                                           @PathVariable long id,
                                           @Parameter(description = "an Entity 'report' in database")
                                           @RequestBody ReportDog reportDog) {
        if (repositoryReportDog.get(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        repositoryReportDog.delete(id);
        repositoryReportDog.save(reportDog);
        return ResponseEntity.ok().body(reportDog.getId());
    }

    @Operation(summary = "Getting all reports")
    @ApiResponse(
            responseCode = "200",
            description = "Users has been returned successfully",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    array = @ArraySchema(schema = @Schema(implementation = UserCat[].class)))
    )
    @GetMapping("/")
    public ResponseEntity<List<ReportDog>> getAll() {
        return ResponseEntity.ok().body(repositoryReportDog.findAll());
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
    public ResponseEntity<Void> deleteReport(@Parameter(description = "id of a report in a report.DB", example = "1")
                                             @PathVariable long id) {
        if (repositoryReportDog.get(id).isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        repositoryReportDog.delete(id);
        return ResponseEntity.ok().build();
    }
}



