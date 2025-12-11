package pe.edu.certus.rescatyfrontend.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.certus.rescatyfrontend.dto.*;
import org.springframework.web.client.RestClient;

@Controller
public class AuthFrontController {

    private final RestClient client;

    public AuthFrontController(RestClient client) {
        this.client = client;
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirect) {

        LoginRequest req = new LoginRequest(email, password);

        try {
            LoginResponse res = client.post()
                    .uri("http://localhost:8080/api/auth/login")
                    .body(req)
                    .retrieve()
                    .body(LoginResponse.class);

            session.setAttribute("usuarioSesion", new UsuarioSesion(res));
            return "redirect:/home";

        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Credenciales incorrectas");
            return "redirect:/";
        }
    }

    @PostMapping("/register")
    public String register(RegisterRequest req, RedirectAttributes redirect) {

        try {
            client.post()
                    .uri("http://localhost:8080/api/auth/register")
                    .body(req)
                    .retrieve()
                    .toBodilessEntity();

            redirect.addFlashAttribute("success", "Cuenta creada correctamente.");
            return "redirect:/";

        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Hubo un error al registrar");
            return "redirect:/";
        }
    }
}
