package pe.edu.certus.rescatyfrontend.dto;

public class RegisterRequest {

    private String nombres;
    private String apellido;
    private String email;
    private String telefono;
    private String dni;
    private String password;

    public RegisterRequest() {}

	public RegisterRequest(String nombres, String apellido, String email, String telefono, String dni,
			String password) {
		this.nombres = nombres;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.dni = dni;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    

}
