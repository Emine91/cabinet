package cabinet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="rendevous")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="daterdv")
    private Date daterdv;


    @ManyToOne()
    private Patient patient;
    @ManyToOne()
    private Medecin medecin;
    @JsonIgnore
    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation;
}
