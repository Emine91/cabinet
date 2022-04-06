package cabinet.service;

import cabinet.advice.NotFoundException;
import cabinet.model.RendezVous;
import cabinet.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RdvService {

    @Autowired
    private RendezVousRepository repo;

    public List<RendezVous> getAllRdv(){
        List<RendezVous>rdvs=new ArrayList<RendezVous>();
        repo.findAll().forEach(rdvs::add);
        if(rdvs.isEmpty()){
            throw new NotFoundException("db is empty");
        }else{
             return rdvs;
        }
    }

    public RendezVous getRdvById(long id){
        Optional<RendezVous> rdv=repo.findById(id);
        if(rdv.isPresent()){
         return rdv.get();
        }else{
          throw new NotFoundException("l id recherche n'existe pas");
        }
    }

    public RendezVous addRdv(RendezVous rdv){
        return  repo.save(rdv);
    }

    public RendezVous modRdv(RendezVous rdv , long id){
        Optional<RendezVous>rd=repo.findById(id);
        if(rd.isPresent()){
        RendezVous r=rd.get();
        r.setMedecin(rdv.getMedecin());
        r.setPatient(rdv.getPatient());
        r.setDaterdv(rdv.getDaterdv());
        return r;
        }else{
            throw new NotFoundException("rdv recherche n existe pas");
        }
    }
    public void delRdv(long id){
        repo.deleteById(id);
    }
}
