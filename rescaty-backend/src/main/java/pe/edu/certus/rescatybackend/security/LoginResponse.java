package pe.edu.certus.rescatybackend.security;

public class LoginResponse {

    private String token;
    private Long id;
    private String nombres;
    private String apellido;
    private String email;
    private String telefono;
    private String dni;

    public LoginResponse(String token, Long id, String nombres, String apellido, String email, String telefono, String dni) {
    	this.token = token;
    	this.id = id;
        this.nombres = nombres;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
    }

    public String getToken() { 
    	return token; 
    }
    
    public Long getId() {
		return id;
    }
    
    public String getNombres() { 
    	return nombres; 
    }
    
    public String getApellido() { 
    	return apellido; 
    }
    
    public String getEmail() { 
    	return email; 
    }
    
    public String getTelefono() {
    	return telefono;
    }
    
    public String getDni() { 
    	return dni; 
    }
}
