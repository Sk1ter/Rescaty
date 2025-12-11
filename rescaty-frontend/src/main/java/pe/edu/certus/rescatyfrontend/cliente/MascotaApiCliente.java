package pe.edu.certus.rescatyfrontend.cliente;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import pe.edu.certus.rescatyfrontend.dto.UsuarioSesion;
import pe.edu.certus.rescatyfrontend.modelo.Mascota;
import java.util.Arrays;
import java.util.List;

@Component
public class MascotaApiCliente {

    private static final String BASE_URL = "http://localhost:8080/api/mascotas";
    private final RestClient restClient;

    public MascotaApiCliente(HttpSession session) {

        this.restClient = RestClient.builder()
                .requestInterceptor((request, body, execution) -> {

                    UsuarioSesion user = (UsuarioSesion) session.getAttribute("usuarioSesion");

                    if (user != null && user.getToken() != null) {
                        request.getHeaders().add("Authorization", "Bearer " + user.getToken());
                    }

                    return execution.execute(request, body);
                })
                .build();
    }

    public List<Mascota> listarMascotas() {
        Mascota[] mascotas = restClient.get()
                .uri(BASE_URL)
                .retrieve()
                .body(Mascota[].class);

        return Arrays.asList(mascotas);
    }

    public Mascota crearMascota(Mascota mascota) {
        return restClient.post()
                .uri(BASE_URL)
                .body(mascota)
                .retrieve()
                .body(Mascota.class);
    }

    public Mascota actualizarMascota(Long id, Mascota mascota) {
        return restClient.put()
                .uri(BASE_URL + "/" + id)
                .body(mascota)
                .retrieve()
                .body(Mascota.class);
    }

    public void eliminarMascota(Long id) {
        restClient.delete()
                .uri(BASE_URL + "/" + id)
                .retrieve()
                .body(String.class);
    }

    public Mascota obtenerMascota(Long id) {
        return restClient.get()
                .uri(BASE_URL + "/" + id)
                .retrieve()
                .body(Mascota.class);
    }
}
