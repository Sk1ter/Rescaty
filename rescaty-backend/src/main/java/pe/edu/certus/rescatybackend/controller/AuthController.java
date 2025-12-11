package pe.edu.certus.rescatybackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import pe.edu.certus.rescatybackend.model.Usuario;
import pe.edu.certus.rescatybackend.repository.UsuarioRepository;
import pe.edu.certus.rescatybackend.security.JwtUtil;
import pe.edu.certus.rescatybackend.security.LoginResponse;
import pe.edu.certus.rescatybackend.service.UsuarioService;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
@Tag(name = "Autenticación", description = "Endpoints para registro, login y validación de sesión")
public class AuthController {

    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;

    public AuthController(UsuarioService usuarioService,
                          UsuarioRepository usuarioRepository,
                          JwtUtil jwtUtil) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
    }
    
    @Operation(
            summary = "Registrar un nuevo usuario",
            description = "Crea un nuevo usuario enviando los datos necesarios",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = Usuario.class),
                            mediaType = "application/json"
                    )
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuario registrado correctamente"),
                    @ApiResponse(responseCode = "400", description = "El correo ya existe en el sistema")
            }
    )
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario nuevoUsuario) {

        if (usuarioRepository.findByEmail(nuevoUsuario.getEmail()) != null) {
            return ResponseEntity.badRequest().body("El email ya está registrado");
        }

        Usuario registrado = usuarioService.registrar(nuevoUsuario);

        return ResponseEntity.ok(registrado);
    }

    @Operation(
            summary = "Iniciar sesión",
            description = "Devuelve un token JWT si el correo y contraseña son válidos",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Login exitoso",
                            content = @Content(schema = @Schema(implementation = LoginResponse.class))
                    ),
                    @ApiResponse(responseCode = "401", description = "Credenciales incorrectas")
            }
    )
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario datosLogin) {

        Usuario usuario = usuarioService.login(datosLogin.getEmail(), datosLogin.getPassword());

        if (usuario == null) {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
        String token = jwtUtil.generateToken(usuario.getEmail());
        LoginResponse response = new LoginResponse(
                token,
                usuario.getId(),
                usuario.getNombres(),
                usuario.getApellido(),
                usuario.getEmail(),
                usuario.getTelefono(),
                usuario.getDni()
        );

        return ResponseEntity.ok(response);
    }
    
    @Operation(
            summary = "Obtener información del usuario autenticado",
            description = "Requiere un token JWT válido en el header Authorization",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuario encontrado"),
                    @ApiResponse(responseCode = "404", description = "Usuario no encontrado"),
                    @ApiResponse(responseCode = "401", description = "Token inválido o ausente")
            }
    )
    
    @GetMapping("/me")
    public ResponseEntity<?> me(@RequestHeader("Authorization") String authHeader) {

        String token = authHeader.replace("Bearer ", "");
        String email = jwtUtil.getEmailFromToken(token);

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }

        return ResponseEntity.ok(usuario);
    }
}
