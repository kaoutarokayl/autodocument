package autodoc.autodoc.controller;





import autodoc.autodoc.entities.Reponse;
import autodoc.autodoc.repositories.ReponseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reponses")
public class ReponseController {
    private final ReponseRepository reponseRepository;

    public ReponseController(ReponseRepository reponseRepository) {
        this.reponseRepository = reponseRepository;
    }

    @GetMapping
    public List<Reponse> getAllReponses() {
        return reponseRepository.findAll();
    }

    @PostMapping
    public Reponse createReponse(@RequestBody Reponse reponse) {
        return reponseRepository.save(reponse);
    }
}
