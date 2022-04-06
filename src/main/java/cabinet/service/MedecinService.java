package cabinet.service;

import cabinet.advice.InternalServerException;
import cabinet.advice.NotFoundException;
import cabinet.model.Medecin;
import cabinet.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedecinService {

    @Autowired
    private MedecinRepository repo;


    public List<Medecin> getAllMed(){
        List<Medecin>medecins=new ArrayList<Medecin>();
        repo.findAll().forEach(medecins::add);
        if(medecins.isEmpty()){
            throw new NotFoundException("bd est vide");
        }else{
            return medecins;
        }
    }

    public Medecin getById(long id){
        Optional<Medecin> med=repo.findById(id);
        if(med.isPresent()){
         return med.get();
        }else{
            throw new NotFoundException("l'id que vous chercher n'existe pas");
        }
    }

    public Medecin addMedecin(Medecin medecin){
        try{
         Medecin med=repo.save(medecin);
         return med;
        }catch(Exception ex){
            throw new InternalServerException("interel server probleme");
        }
    }
    public Medecin modMedecin(Medecin medecin, long id){
        Optional<Medecin>med=repo.findById(id);
        if(med.isPresent()){
            Medecin m=med.get();
            m.setNom(medecin.getNom());
            m.setEmail(medecin.getEmail());
            m.setSpecialite(medecin.getSpecialite());
            return repo.save(m);
        }else{
            throw new NotFoundException("le medecin a modifie n'existe pas");
        }
    }

   public void deleteMed(long id){
       try {
           repo.deleteById(id);
       }catch(Exception ex){
           throw new InternalServerException("internal server error cannot delete");
       }
   }

}
