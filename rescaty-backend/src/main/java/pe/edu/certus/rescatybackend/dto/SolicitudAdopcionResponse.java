package pe.edu.certus.rescatybackend.dto;

import java.time.LocalDateTime;

public class SolicitudAdopcionResponse {

    public Long id;
    public Long mascotaId;
    public String nombreMascota;

    public Long usuarioId;
    public String nombreUsuario;

    public String nombreCompleto;
    public String email;
    public String telefono;

    public String motivo;
    public String experiencia;
    public String entornoHogar;
    public String tiempoDisponible;
    public String otrasMascotas;

    public Boolean aceptaCondiciones;
    public String estado;
    public LocalDateTime fechaSolicitud;

    public SolicitudAdopcionResponse() {
    }

	public SolicitudAdopcionResponse(Long id, Long mascotaId, String nombreMascota, Long usuarioId,
			String nombreUsuario, String nombreCompleto, String email, String telefono, String motivo,
			String experiencia, String entornoHogar, String tiempoDisponible, String otrasMascotas,
			Boolean aceptaCondiciones, String estado, LocalDateTime fechaSolicitud) {
		super();
		this.id = id;
		this.mascotaId = mascotaId;
		this.nombreMascota = nombreMascota;
		this.usuarioId = usuarioId;
		this.nombreUsuario = nombreUsuario;
		this.nombreCompleto = nombreCompleto;
		this.email = email;
		this.telefono = telefono;
		this.motivo = motivo;
		this.experiencia = experiencia;
		this.entornoHogar = entornoHogar;
		this.tiempoDisponible = tiempoDisponible;
		this.otrasMascotas = otrasMascotas;
		this.aceptaCondiciones = aceptaCondiciones;
		this.estado = estado;
		this.fechaSolicitud = fechaSolicitud;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMascotaId() {
		return mascotaId;
	}

	public void setMascotaId(Long mascotaId) {
		this.mascotaId = mascotaId;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
    
}
