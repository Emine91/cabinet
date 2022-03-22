package cabinet.service;

import cabinet.advice.ConflitException;
import cabinet.advice.InternalServerException;
import cabinet.advice.NotFoundException;
import cabinet.model.Patient;
import cabinet.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repo;


    public List<Patient> gelAll() {
     //   try {
            List<Patient> patients = new ArrayList<Patient>();
            repo.findAll().forEach(patients::add);
            if (patients.isEmpty()) {
                throw new NotFoundException("la base de donnes est vide");
            } else {
                return patients;
            }
     /*   } catch (Exception ex) {
            throw new InternalServerException("Internal server problem");
        }*/
    }

    public Patient getById(long id){
        try{
            Optional<Patient> pat=repo.findById(id);
            if(pat.isPresent()){
              return pat.get();
            }else{
                throw new NotFoundException("le patient inexistant");
            }

       }catch(Exception ex){
            throw new InternalServerException("Internal server problem");
        }
    }

    public Patient add(Patient patient){

        try{
       Patient p=repo.findByNomAndPrenom(patient.getNom(),patient.getPrenom());
            if(p.getNom().equals("")){
             throw new ConflitException("ce patient existe deja");
            }else{
                Patient pat=repo.save(patient);
                return pat;
            }

        }catch (Exception ex){
            throw new InternalServerException("Internal server problem");
        }
    }

    public Patient mod(Patient patient, long id){
        try {
     Optional<Patient> pat=repo.findById(id);
     if(pat.isPresent()){
     Patient p=pat.get();
     p.setEmail(patient.getEmail());
     p.setNom(patient.getNom());
     p.setPrenom(patient.getPrenom());
     return repo.save(p);
     }else{
         throw new NotFoundException("la patient recherche n'existe pas");
     }
        }catch(Exception ex){
            throw new InternalServerException("Internal server problem");
        }
    }
    public void del(long id){
        try {
            repo.deleteById(id);
        }catch(Exception ex){
            throw new InternalServerException("Internale server problelm");
        }
    }

}