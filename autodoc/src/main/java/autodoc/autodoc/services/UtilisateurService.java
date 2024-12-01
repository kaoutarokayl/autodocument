package autodoc.autodoc.services;

import java.util.Optional;

import autodoc.autodoc.entities.Utilisateur;
import autodoc.autodoc.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtilisateurService implements UserDetailsService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Correction de l'erreur "Stringname" remplacé par "username"
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByName(username);
        if (utilisateur.isPresent()) {
            var userObj = utilisateur.get();
            return User.builder()
                    .username(userObj.getName())
                    .password(userObj.getPassword())
                    .roles("USER") // Définir les rôles ou autorités ici
                    .build();
        } else {
            throw new UsernameNotFoundException("Utilisateur non trouvé avec le nom : " + username);
        }
    }
}
