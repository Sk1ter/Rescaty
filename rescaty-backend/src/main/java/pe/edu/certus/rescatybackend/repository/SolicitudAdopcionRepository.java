package pe.edu.certus.rescatybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.certus.rescatybackend.model.SolicitudAdopcion;

import java.util.List;

public interface SolicitudAdopcionRepository extends JpaRepository<SolicitudAdopcion, Long> {

    List<SolicitudAdopcion> findByUsuarioId(Long usuarioId);
}
