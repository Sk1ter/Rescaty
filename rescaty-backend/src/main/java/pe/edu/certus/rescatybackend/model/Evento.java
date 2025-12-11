package pe.edu.certus.rescatybackend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Entity
@Table(name = "event")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String organizador;

    private String ubicacion;

    private LocalDate fecha;

    private LocalTime hora;

    private String duracion;

    private Integer participantes;

    private LocalDateTime creadoEn;

    public Evento() {
    }

    public Evento(Long id, String titulo, String organizador, String ubicacion, LocalDate fecha, LocalTime hora,
			String duracion, Integer participantes, LocalDateTime creadoEn) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.organizador = organizador;
		this.ubicacion = ubicacion;
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
		this.participantes = participantes;
		this.creadoEn = creadoEn;
	}

	@PrePersist
    public void prePersist() {
        this.creadoEn = LocalDateTime.now();
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

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Integer getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Integer participantes) {
        this.participantes = participantes;
    }

    public LocalDateTime getCreadoEn() {
        return creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }
}
