package pe.edu.certus.rescatybackend.service;

import java.util.List;
import pe.edu.certus.rescatybackend.model.Evento;

public interface EventoService {

    Evento crear(Evento evento);

    Evento obtenerPorId(Long id);

    List<Evento> listarTodos();

    Evento actualizar(Long id, Evento evento);

    void eliminar(Long id);
}
