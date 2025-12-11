package pe.edu.certus.rescatybackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "solicitudes_adopcion")
public class SolicitudAdopcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long usuarioId;
    private Long mascotaId;

    private String nombreCompleto;
    private String email;
    private String telefono;
    private String dni;

    private String direccion;
    private String ciudad;

    private String motivo;
    private String experiencia;

    @Column(name = "entorno_hogar")
    private String entornoHogar;

    @Column(name = "tiempo_disponible")
    private String tiempoDisponible;

    @Column(name = "otras_mascotas")
    private String otrasMascotas;

    private Boolean aceptaCondiciones;

    private String estado = "PENDIENTE"; // PENDIENTE / APROBADA / RECHAZADA

    public SolicitudAdopcion() {
    }

    public SolicitudAdopcion(Long id, Long usuarioId, Long mascotaId,
                             String nombreCompleto, String email, String telefono,
                             String dni, String direccion, String ciudad,
                             String motivo, String experiencia,
                             String entornoHogar, String tiempoDisponible,
                             String otrasMascotas, Boolean aceptaCondiciones,
                             String estado) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.mascotaId = mascotaId;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.motivo = motivo;
        this.experiencia = experiencia;
        this.entornoHogar = entornoHogar;
        this.tiempoDisponible = tiempoDisponible;
        this.otrasMascotas = otrasMascotas;
        this.aceptaCondiciones = aceptaCondiciones;
        this.estado = estado;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getMascotaId() {
		return mascotaId;
	}

	public void setMascotaId(Long mascotaId) {
		this.mascotaId = mascotaId;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

    
}
