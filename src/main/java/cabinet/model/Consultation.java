package cabinet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name="consultation")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="dateconsultation")
    private Date dateconsultation;
    @Column(name="rapport")
    private String rapport;
    @Column(name="prix")
    private double prix;

    @OneToOne()
    private RendezVous rendezVous;
}
