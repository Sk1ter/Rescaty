package pe.edu.certus.rescatybackend.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.certus.rescatybackend.model.Usuario;
import pe.edu.certus.rescatybackend.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario registrar(Usuario u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return repo.save(u);
    }

    public Usuario login(String email, String password) {
        Usuario u = repo.findByEmail(email);

        if (u == null) return null;

        if (!passwordEncoder.matches(password, u.getPassword()))
            return null;

        return u;
    }
}
