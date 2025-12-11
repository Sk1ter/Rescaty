package pe.edu.certus.rescatybackend.service;

import org.springframework.stereotype.Service;
import pe.edu.certus.rescatybackend.dto.SolicitudAdopcionRequest;
import pe.edu.certus.rescatybackend.model.SolicitudAdopcion;
import pe.edu.certus.rescatybackend.repository.SolicitudAdopcionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudAdopcionService {

    private final SolicitudAdopcionRepository repo;

    public SolicitudAdopcionService(SolicitudAdopcionRepository repo) {
        this.repo = repo;
    }

    public SolicitudAdopcion registrar(SolicitudAdopcionRequest req) {

        SolicitudAdopcion s = new SolicitudAdopcion();

        s.setUsuarioId(req.getUsuarioId());
        s.setMascotaId(req.getMascotaId());
        s.setNombreCompleto(req.getNombreCompleto());
        s.setEmail(req.getEmail());
        s.setTelefono(req.getTelefono());
        s.setMotivo(req.getMotivo());
        s.setExperiencia(req.getExperiencia());
        s.setTiempoDisponible(req.getTiempoDisponible());
        s.setAceptaCondiciones(req.getAceptaCondiciones());

        return repo.save(s);
    }

    // LISTAR TODO
    public List<SolicitudAdopcion> listar() {
        return repo.findAll();
    }

    // LISTAR POR USUARIO
    public List<SolicitudAdopcion> listarPorUsuario(Long usuarioId) {
        return repo.findByUsuarioId(usuarioId);
    }

    // OBTENER POR ID
    public SolicitudAdopcion obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    // ACTUALIZAR ESTADO
    public SolicitudAdopcion actualizarEstado(Long id, String nuevoEstado) {
        Optional<SolicitudAdopcion> opt = repo.findById(id);
        if (opt.isEmpty()) return null;

        SolicitudAdopcion s = opt.get();
        s.setEstado(nuevoEstado);

        return repo.save(s);
    }

    // ELIMINAR
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
