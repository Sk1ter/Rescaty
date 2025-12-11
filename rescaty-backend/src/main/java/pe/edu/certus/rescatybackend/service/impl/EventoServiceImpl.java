package pe.edu.certus.rescatybackend.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.certus.rescatybackend.model.Evento;
import pe.edu.certus.rescatybackend.repository.EventoRepository;
import pe.edu.certus.rescatybackend.service.EventoService;

import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    private final EventoRepository repo;

    public EventoServiceImpl(EventoRepository repo) {
        this.repo = repo;
    }

    @Override
    public Evento crear(Evento evento) {
        return repo.save(evento);
    }

    @Override
    public Evento obtenerPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Evento> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Evento actualizar(Long id, Evento datos) {
        Evento evento = obtenerPorId(id);
        if (evento == null) return null;

        evento.setTitulo(datos.getTitulo());
        evento.setOrganizador(datos.getOrganizador());
        evento.setUbicacion(datos.getUbicacion());
        evento.setFecha(datos.getFecha());
        evento.setHora(datos.getHora());
        evento.setDuracion(datos.getDuracion());
        evento.setParticipantes(datos.getParticipantes());

        return repo.save(evento);
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
