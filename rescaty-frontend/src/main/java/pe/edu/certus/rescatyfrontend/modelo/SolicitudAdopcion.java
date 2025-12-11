package pe.edu.certus.rescatyfrontend.modelo;

public class SolicitudAdopcion {

    private Long id;
    private Long usuarioId;
    private Long mascotaId;

    private String nombreCompleto;
    private String email;
    private String telefono;

    private String motivo;
    private String experiencia;
    private String espacio;
    private String tiempoDisponible;

    private Boolean aceptaCondiciones;

    private String estado; // PENDIENTE / APROBADA / RECHAZADA

    public SolicitudAdopcion() {}

    // Getters y Setters
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

    public String getEspacio() {
        return espacio;
    }

    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    public String getTiempoDisponible() {
        return tiempoDisponible;
    }

    public void setTiempoDisponible(String tiempoDisponible) {
        this.tiempoDisponible = tiempoDisponible;
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
