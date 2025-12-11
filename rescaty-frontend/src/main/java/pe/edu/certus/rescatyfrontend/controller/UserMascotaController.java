package pe.edu.certus.rescatyfrontend.controller;

import jakarta.servlet.http.HttpSession;
import pe.edu.certus.rescatyfrontend.cliente.MascotaApiCliente;
import pe.edu.certus.rescatyfrontend.cliente.SolicitudAdopcionApiCliente;
import pe.edu.certus.rescatyfrontend.dto.UsuarioSesion;
import pe.edu.certus.rescatyfrontend.modelo.Mascota;
import pe.edu.certus.rescatyfrontend.modelo.SolicitudAdopcion;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserMascotaController {

    private final MascotaApiCliente mascotaApi;
    private final SolicitudAdopcionApiCliente adopcionApi;

    public UserMascotaController(MascotaApiCliente mascotaApi,
                                 SolicitudAdopcionApiCliente adopcionApi) {
        this.mascotaApi = mascotaApi;
        this.adopcionApi = adopcionApi;
    }

    @GetMapping("/usermascotas")
    public String mostrarMascotasUsuario(HttpSession session, Model model) {

        UsuarioSesion usuario = (UsuarioSesion) session.getAttribute("usuarioSesion");

        if (usuario == null)
            return "redirect:/";

        model.addAttribute("usuario", usuario);
        model.addAttribute("mascotas", mascotaApi.listarMascotas());

        return "usermascota";
    }

    @GetMapping("/mascota/{id}")
    public String verMascotaDetalle(@PathVariable Long id,
                                    HttpSession session,
                                    Model model) {

        UsuarioSesion usuario = (UsuarioSesion) session.getAttribute("usuarioSesion");

        if (usuario == null)
            return "redirect:/";

        Mascota mascota = mascotaApi.obtenerMascota(id);

        if (mascota == null) {
            model.addAttribute("mensaje", "Mascota no encontrada");
            return "usermascotas";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("mascota", mascota);

        return "detalle-mascota";
    }

    @PostMapping("/mascota/{id}/adoptar")
    public String enviarSolicitudAdopcion(@PathVariable Long id,
                                          @ModelAttribute SolicitudAdopcion form,
                                          HttpSession session,
                                          Model model) {

        UsuarioSesion user = (UsuarioSesion) session.getAttribute("usuarioSesion");

        if (user == null)
            return "redirect:/";

        Mascota mascota = mascotaApi.obtenerMascota(id);

        if (mascota == null) {
            model.addAttribute("mensaje", "Mascota no encontrada");
            return "redirect:/usermascotas";
        }

        form.setMascotaId(mascota.getId());
        form.setUsuarioId(user.getId());
        form.setNombreCompleto(user.getNombres() + " " + user.getApellido());
        form.setEmail(user.getEmail());
        form.setTelefono(user.getTelefono());

        if (form.getAceptaCondiciones() == null) {
            form.setAceptaCondiciones(false);
        }

        adopcionApi.crearSolicitud(form);

        return "redirect:/mascota/" + id + "?solicitud=ok";
    }
    
    @GetMapping("/mis-solicitudes")
    public String verSolicitudesUsuario(HttpSession session, Model model) {

        UsuarioSesion usuario = (UsuarioSesion) session.getAttribute("usuarioSesion");
        if (usuario == null)
            return "redirect:/";

        List<SolicitudAdopcion> solicitudes = adopcionApi.listarPorUsuario(usuario.getId());

        model.addAttribute("usuario", usuario);
        model.addAttribute("solicitudes", solicitudes);

        return "mis-solicitudes";
    }

    @GetMapping("/solicitud/{id}")
    public String verDetalleSolicitud(@PathVariable Long id,
                                      HttpSession session,
                                      Model model) {

        UsuarioSesion usuario = (UsuarioSesion) session.getAttribute("usuarioSesion");
        if (usuario == null)
            return "redirect:/";

        SolicitudAdopcion sol = adopcionApi.obtenerSolicitud(id);

        if (sol == null)
            return "redirect:/mis-solicitudes";

        model.addAttribute("usuario", usuario);
        model.addAttribute("solicitud", sol);

        return "detalle-solicitud";
    }

    @GetMapping("/solicitud/{id}/eliminar")
    public String eliminarSolicitud(@PathVariable Long id,
                                    HttpSession session) {

        UsuarioSesion usuario = (UsuarioSesion) session.getAttribute("usuarioSesion");
        if (usuario == null)
            return "redirect:/";

        adopcionApi.eliminarSolicitud(id);

        return "redirect:/mis-solicitudes?deleted=ok";
    }
}
