package pe.edu.certus.rescatybackend.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.certus.rescatybackend.model.Mascota;
import pe.edu.certus.rescatybackend.repository.MascotaRepository;
import pe.edu.certus.rescatybackend.service.MascotaService;

import java.util.List;

@Service
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository repo;

    public MascotaServiceImpl(MascotaRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Mascota> listar() {
        return repo.findAll();
    }

    @Override
    public Mascota obtener(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Mascota crear(Mascota mascota) {
        return repo.save(mascota);
    }

    @Override
    public Mascota actualizar(Long id, Mascota mascota) {
        Mascota m = repo.findById(id).orElse(null);

        if (m == null) return null;

        m.setNombre(mascota.getNombre());
        m.setEspecie(mascota.getEspecie());
        m.setRaza(mascota.getRaza());
        m.setEdadMeses(mascota.getEdadMeses());
        m.setSexo(mascota.getSexo());
        m.setSalud(mascota.getSalud());
        m.setEstado(mascota.getEstado());

        return repo.save(m);
    }

    @Override
    public boolean eliminar(Long id) {
        if (!repo.existsById(id)) return false;

        repo.deleteById(id);
        return true;
    }
}
