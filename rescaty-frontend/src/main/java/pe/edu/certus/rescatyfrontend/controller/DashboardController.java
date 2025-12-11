package pe.edu.certus.rescatyfrontend.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.edu.certus.rescatyfrontend.dto.UsuarioSesion;
import pe.edu.certus.rescatyfrontend.cliente.EventoApiCliente;

@Controller
public class DashboardController {

    private final EventoApiCliente api;

    public DashboardController(EventoApiCliente api) {
        this.api = api;
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        UsuarioSesion usuario = (UsuarioSesion) session.getAttribute("usuarioSesion");

        if (usuario == null) {
            return "redirect:/";
        }

        model.addAttribute("usuario", usuario);
        model.addAttribute("events", api.listarEventos());

        return "dashboard";
    }
    
}
