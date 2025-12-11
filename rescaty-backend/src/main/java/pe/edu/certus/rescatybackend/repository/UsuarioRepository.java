package pe.edu.certus.rescatybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.certus.rescatybackend.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}