package cabinet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="medecin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nom")
    private String nom;
    @Column(name="specialite")
    private String specialite;
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
    Collection<RendezVous>rendezVous;

}
