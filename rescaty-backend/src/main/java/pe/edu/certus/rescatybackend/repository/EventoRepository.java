package pe.edu.certus.rescatybackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.certus.rescatybackend.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
