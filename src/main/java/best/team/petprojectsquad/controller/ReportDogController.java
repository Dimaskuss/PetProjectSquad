package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.ReportCat;
import best.team.petprojectsquad.entity.ReportDog;
import best.team.petprojectsquad.entity.UserCat;
import best.team.petprojectsquad.entity.UserDog;
import best.team.petprojectsquad.service.RepositoryService;
import best.team.petprojectsquad.service.controllerService.ReportDogControllerService;
import best.team.petprojectsquad.service.controllerServiceImpl.ReportDogControllerServiceImpl;
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
@Tag(name = "Report", description = "Api for working with report on how cat feels in a new place")
public class ReportDogController {
    private final ReportDogControllerService service;
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
        return ResponseEntity.ok(service.getReferenceById(id));
    }

    @Operation(summary = "Adding report, returning id of added report")
    @ApiResponse(
            responseCode = "200",
            description = "Report has been added to database successfully!"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Some fields may be empty or may contain irrelevant type!"
    )
    @PostMapping("/userDogId{userDogId}")
    public ResponseEntity<Long> addReport(@Parameter(description = "id of a userCat in a userDog.DB", example = "1") @PathVariable long userDogId,
                                          @Parameter(description = "An Entity 'reportDog' in database") @RequestBody ReportDog reportDog) {
        return ResponseEntity.ok().body(service.save(reportDog, userDogId));
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
        long id1 = service.getReferenceById(id).getUserDog().getId();
        service.deleteById(id);
        service.save(reportDog, id1);
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
        return ResponseEntity.ok().body(service.findAll());
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
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}



