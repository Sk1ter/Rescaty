package pe.edu.certus.rescatyfrontend.controller;

import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.edu.certus.rescatyfrontend.cliente.MascotaApiCliente;
import pe.edu.certus.rescatyfrontend.dto.UsuarioSesion;
import pe.edu.certus.rescatyfrontend.modelo.Mascota;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    private final MascotaApiCliente api;

    public MascotaController(MascotaApiCliente api) {
        this.api = api;
    }

    @GetMapping
    public String listarMascotas(HttpSession session, Model model) {

        UsuarioSesion usuario = (UsuarioSesion) session.getAttribute("usuarioSesion");
        if (usuario == null) {
            return "redirect:/";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("mascotas", api.listarMascotas());

        return "mascotas";
    }

    @PostMapping("/crear")
    public String crearMascota(Mascota mascota) {
        api.crearMascota(mascota);
        return "redirect:/mascotas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable Long id,
                                HttpSession session,
                                Model model) {

        UsuarioSesion usuario = (UsuarioSesion) session.getAttribute("usuarioSesion");
        if (usuario == null) {
            return "redirect:/";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("mascotas", api.listarMascotas());

        Mascota mascota = api.obtenerMascota(id);
        model.addAttribute("mascotaEdit", mascota);
        model.addAttribute("abrirModalEditarMascota", true);

        return "mascotas";
    }
    
    @GetMapping("/buscar")
    public String buscarMascota(@RequestParam Long id,
                                HttpSession session,
                                Model model) {

        UsuarioSesion usuario = (UsuarioSesion) session.getAttribute("usuarioSesion");
        if (usuario == null) {
            return "redirect:/";
        }

        model.addAttribute("usuario", usuario);

        try {
            Mascota mascota = api.obtenerMascota(id);

            model.addAttribute("mascotas", List.of(mascota));

        } catch (Exception e) {
            model.addAttribute("mensaje", "No se encontró la mascota con ID: " + id);
        }

        return "mascotas";
    }

    @PostMapping("/editar/{id}")
    public String editarMascota(@PathVariable Long id, Mascota mascota) {
        api.actualizarMascota(id, mascota);
        return "redirect:/mascotas";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable Long id) {
        api.eliminarMascota(id);
        return "redirect:/mascotas";
    }
    
}
