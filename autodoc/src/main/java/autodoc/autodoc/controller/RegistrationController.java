package autodoc.autodoc.controller;

import autodoc.autodoc.entities.Utilisateur;
import autodoc.autodoc.repositories.UtilisateurRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class RegistrationController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping(value = "/signup", consumes = "application/json")
    public Utilisateur createUtilisateur(@RequestBody @Valid Utilisateur utilisateur) {
        utilisateur.setPassword(passwordEncoder.encode(utilisateur
                .getPassword()));
        return utilisateurRepository.save(utilisateur);
    }

}
