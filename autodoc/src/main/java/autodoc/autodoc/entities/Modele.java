package autodoc.autodoc.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;
    private String filePath;

    @OneToMany(mappedBy = "modele", cascade = CascadeType.ALL)
    private List<Document> documents;

    @OneToMany(mappedBy = "modele", cascade = CascadeType.ALL)
    private List<Question> questions;
}
