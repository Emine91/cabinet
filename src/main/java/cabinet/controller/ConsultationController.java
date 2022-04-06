package cabinet.controller;

import cabinet.model.Consultation;
import cabinet.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ConsultationController {

    @Autowired
    private ConsultationService service;

    @GetMapping("/consultations")
    public ResponseEntity<List<Consultation>>getAll(){
        return new ResponseEntity<>(service.getAllConsult(), HttpStatus.OK);
    }
    @GetMapping("/consultations/{id}")
    public ResponseEntity<Consultation>getById(@PathVariable("id")long id){
        return new ResponseEntity<>(service.getConsultById(id), HttpStatus.OK);
    }
    @PostMapping("/consultations")
    public ResponseEntity<Consultation>addConsult(@RequestBody Consultation consult){
        return new ResponseEntity<>(service.addConsult(consult), HttpStatus.CREATED);
    }
    @PutMapping("/consultations/{id}")
    public ResponseEntity<Consultation>modConsult(@RequestBody Consultation consult,@PathVariable("id") long id){
        return new ResponseEntity<>(service.modConsult(consult, id), HttpStatus.OK);
    }
    @DeleteMapping("/consultations/{id}")
    public ResponseEntity<HttpStatus>delConsult(@PathVariable("id")long id){
        service.delConsult(id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }



}
