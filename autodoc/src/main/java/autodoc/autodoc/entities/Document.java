package autodoc.autodoc.entities;



import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    @JsonProperty("utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "modele_id")
    private Modele modele;
}
