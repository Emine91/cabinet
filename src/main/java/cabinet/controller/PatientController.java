package cabinet.controller;

import cabinet.model.Patient;
import cabinet.service.PatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Patient", description = "the Patient API")
public class PatientController {

    @Autowired
    private PatientService service;

    @Operation(summary = "Find All Patient", description = "Recuperer tous les patients", tags = { "Patient" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")	})
    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatient(){
        return new ResponseEntity<>(service.gelAll(), HttpStatus.OK);
    }
    @GetMapping("/patients/{id}")
    public ResponseEntity<Patient>getPById(@PathVariable("id")long id){
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Add a new patient", description = "", tags = { "patient" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Patient created"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "Patient already exists") })
    @PostMapping("/patients")
    public ResponseEntity<Patient>save( @Valid @RequestBody Patient patient){
        return new ResponseEntity<>(service.add(patient), HttpStatus.OK);
    }
    @DeleteMapping("/patients/{id}")
    public ResponseEntity<HttpStatus>delP(@PathVariable("id")long id){
        service.del(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
