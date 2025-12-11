package pe.edu.certus.rescatyfrontend.dto;

public class LoginResponse {
    private String token;
    private String id;
    private String nombres;
    private String apellido;
    private String email;
    private String telefono;
    private String dni;

    public LoginResponse() {}

	public LoginResponse(String token, String nombres, String apellido, String email, String telefono, String dni, String id) {
		super();
		this.token = token;
		this.nombres = nombres;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.dni = dni;
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
    
}
