package cabinet.service;

import cabinet.advice.InternalServerException;
import cabinet.advice.NotFoundException;
import cabinet.model.Consultation;
import cabinet.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultationService {

    @Autowired
    private ConsultationRepository repo;

    public List<Consultation>getAllConsult(){
        List<Consultation>consults=new ArrayList<Consultation>();
        repo.findAll().forEach(consults::add);
        if(consults.isEmpty()){
throw new NotFoundException("bd est vide");
        }else{
return consults;
        }
    }

   public Consultation getConsultById(long id){
       Optional<Consultation>con=repo.findById(id);
       if(con.isPresent()){
return  con.get();
       }else{
           throw new NotFoundException("la consultation de l id"+id +"n'existe pas");
       }
   }
   public Consultation addConsult(Consultation consul){
       try {
           Consultation con = repo.save(consul);
           return con;
       }catch(Exception ex){
       throw new InternalServerException("probleme server");
       }
   }
   public Consultation modConsult(Consultation consult, long id){
        Optional<Consultation>con=repo.findById(id);
        if(con.isPresent()){
            Consultation c=con.get();
            c.setDateconsultation(consult.getDateconsultation());
            c.setPrix(consult.getPrix());
            c.setRapport(consult.getRapport());
            c.setRendezVous(consult.getRendezVous());
            return repo.save(c);
        }else{
            throw new NotFoundException("on ne peut pas modifier id enexistant");
        }
   }
   public void delConsult(long id){
    repo.deleteById(id);
   }

}
