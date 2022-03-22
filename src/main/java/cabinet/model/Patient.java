package cabinet.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name="patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name="nom")
    private String nom;
    @NotBlank
    @Size(max = 100)
    @Column(name="prenom")
    private String prenom;
    @Schema(description = "Email address of the contact.",
            example = "jessica@ngilang.com", required = false)
    @Email(message = "Email Address")
    @Column(name="email")
    private String email;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY )
    Collection<RendezVous> rendezVous;
}
