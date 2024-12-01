package autodoc.autodoc.controller;





import autodoc.autodoc.entities.Modele;
import autodoc.autodoc.repositories.ModeleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modeles")
public class ModeleController {
    private final ModeleRepository modeleRepository;

    public ModeleController(ModeleRepository modeleRepository) {
        this.modeleRepository = modeleRepository;
    }

    @GetMapping
    public List<Modele> getAllModeles() {
        return modeleRepository.findAll();
    }

    @PostMapping
    public Modele createModele(@RequestBody Modele modele) {
        return modeleRepository.save(modele);
    }
}
