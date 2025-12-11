package pe.edu.certus.rescatybackend.dto;

public class SolicitudAdopcionRequest {

    public Long mascotaId;
    public Long usuarioId;
    public String nombreCompleto;
    public String email;
    public String telefono;
    public String direccion;
    public String ciudad;
    public String motivo;
    public String experiencia;
    public String entornoHogar;
    public String tiempoDisponible;
    public String otrasMascotas;
    public Boolean aceptaCondiciones;

    public SolicitudAdopcionRequest() {
    }
    
    

	public SolicitudAdopcionRequest(Long mascotaId, Long usuarioId, String nombreCompleto, String email,
			String telefono, String direccion, String ciudad, String motivo, String experiencia, String entornoHogar,
			String tiempoDisponible, String otrasMascotas, Boolean aceptaCondiciones) {
		super();
		this.mascotaId = mascotaId;
		this.usuarioId = usuarioId;
		this.nombreCompleto = nombreCompleto;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.motivo = motivo;
		this.experiencia = experiencia;
		this.entornoHogar = entornoHogar;
		this.tiempoDisponible = tiempoDisponible;
		this.otrasMascotas = otrasMascotas;
		this.aceptaCondiciones = aceptaCondiciones;
	}



	public Long getMascotaId() {
		return mascotaId;
	}

	public void setMascotaId(Long mascotaId) {
		this.mascotaId = mascotaId;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	public String getEntornoHogar() {
		return entornoHogar;
	}

	public void setEntornoHogar(String entornoHogar) {
		this.entornoHogar = entornoHogar;
	}

	public String getTiempoDisponible() {
		return tiempoDisponible;
	}

	public void setTiempoDisponible(String tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public String getOtrasMascotas() {
		return otrasMascotas;
	}

	public void setOtrasMascotas(String otrasMascotas) {
		this.otrasMascotas = otrasMascotas;
	}

	public Boolean getAceptaCondiciones() {
		return aceptaCondiciones;
	}

	public void setAceptaCondiciones(Boolean aceptaCondiciones) {
		this.aceptaCondiciones = aceptaCondiciones;
	}

    
}
