package pe.edu.certus.rescatyfrontend.modelo;

public class Evento {

    private Long id;
    private String titulo;
    private String organizador;
    private String fecha;
    private String hora;
    private String duracion;
    private String ubicacion;
    private Integer participantes;
    
	public Evento() {

	}

	public Evento(Long id, String titulo, String organizador, String fecha, String hora, String ubicacion,
			Integer participantes, String duracion) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.organizador = organizador;
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
		this.ubicacion = ubicacion;
		this.participantes = participantes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getOrganizador() {
		return organizador;
	}

	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Integer participantes) {
		this.participantes = participantes;
	}
    
	public String getDuracion() {
	    return duracion;
	}

	public void setDuracion(String duracion) {
	    this.duracion = duracion;
	}
}
