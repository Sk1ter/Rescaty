package pe.edu.certus.rescatyfrontend.cliente;

import java.util.Arrays;
import java.util.List;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import pe.edu.certus.rescatyfrontend.dto.UsuarioSesion;
import pe.edu.certus.rescatyfrontend.modelo.Evento;

@Component
public class EventoApiCliente {

	// CREAMOS URL BASE DE LA API DE EVENTOS DEL BACKEND
	// CON ESTO CENTRALIZAMOS EL ENDPOINT PARA CAMBIAR EN UN SOLO LUGAR SI ES NECESARIO
	
    private final String BASE_URL = "http://localhost:8080/api/eventos";
    private final RestClient restClient;

    
    
    // SE CONSTRUYE EL RESTCLIENT PARA AGREGAR AUTOMATICAMENTE EL TOKEN DEL USUARIO
    // LOGUEADO, TAMBIEN SE CONECTA EL FRONTEND CON LA API SIN REPETIR CODIGO
    
    public EventoApiCliente(HttpSession session) {

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
    
    // LISTAR EVENTOS

    public List<Evento> listarEventos() {
        Evento[] eventos = restClient.get()
                .uri(BASE_URL) // /api/eventos
                .retrieve()
                .body(Evento[].class);

        return Arrays.asList(eventos);
        // RETORNA UNA LISTA DE EVENTOS DEL BACK
    
    }
    
    public Evento crearEvento(Evento e) {
        return restClient.post()
                .uri(BASE_URL)
                .body(e)
                .retrieve()
                .body(Evento.class);
        
    }

    public Evento actualizarEvento(Long id, Evento e) {
        return restClient.put()
                .uri(BASE_URL + "/" + id)
                .body(e)
                .retrieve()
                .body(Evento.class);
    }

    public void eliminarEvento(Long id) {
        restClient.delete()
                .uri(BASE_URL + "/" + id)
                .retrieve()
        		.body(String.class);
    }

    public Evento obtenerEvento(Long id) {
        return restClient.get()
                .uri(BASE_URL + "/" + id)
                .retrieve()
                .body(Evento.class);
    }
}
