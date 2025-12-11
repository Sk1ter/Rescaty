package pe.edu.certus.rescatyfrontend.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pe.edu.certus.rescatyfrontend.dto.UsuarioSesion;

@ControllerAdvice
public class GlobalControllerUser {

    @ModelAttribute("user")
    public UsuarioSesion usuarioSesion(HttpSession session) {
        return (UsuarioSesion) session.getAttribute("usuarioSesion");
    }
}
