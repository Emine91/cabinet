package cabinet.controller;

import cabinet.model.RendezVous;
import cabinet.service.RdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RdvController {

    @Autowired
    private RdvService service;


    @GetMapping("/rdvs")
    public ResponseEntity<List<RendezVous>> rdvs() {
        return new ResponseEntity<>(service.getAllRdv(), HttpStatus.OK);
    }

    @GetMapping("/rdvs/{id}")
    public ResponseEntity<RendezVous> getById(@PathVariable("id") long id) {
        return new ResponseEntity<>(service.getRdvById(id), HttpStatus.OK);
    }

    @PostMapping("/rdvs")
    public ResponseEntity<RendezVous> add(@RequestBody RendezVous rdv) {
        return new ResponseEntity<>(service.addRdv(rdv), HttpStatus.CREATED);
    }

    @PutMapping("/rdvs/{id}")
    public ResponseEntity<RendezVous> mod(@PathVariable("id") long id, @RequestBody RendezVous rdv) {
        return new ResponseEntity<>(service.modRdv(rdv, id), HttpStatus.OK);
    }

    @DeleteMapping("/rdvs/{id}")
    public ResponseEntity<HttpStatus> del(@PathVariable("id") long id) {
        service.delRdv(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
