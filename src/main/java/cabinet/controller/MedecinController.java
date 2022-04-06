package cabinet.controller;

import cabinet.model.Medecin;
import cabinet.service.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MedecinController {

    @Autowired
    private MedecinService service;

    @GetMapping("/medecins")
    public ResponseEntity<List<Medecin>> getAll(){
        return new ResponseEntity<>(service.getAllMed(), HttpStatus.OK);
    }
    @GetMapping("/medecins/{id}")
    public ResponseEntity<Medecin>getById(@PathVariable("id")long id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }
    @PutMapping("/medecins/{id}")
    public ResponseEntity<Medecin>modMed(@RequestBody Medecin medecin,@PathVariable("id")long id){
        return new ResponseEntity<>(service.modMedecin(medecin ,id),HttpStatus.OK);
    }
    @PostMapping("/medecins")
    public ResponseEntity<Medecin>addMedecin(@RequestBody Medecin medecin){
        return new ResponseEntity<>(service.addMedecin(medecin),HttpStatus.CREATED);
    }
    @DeleteMapping("/medecins/{id}")
    public ResponseEntity<HttpStatus>delMed(@PathVariable("id")long id){
        service.deleteMed(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
