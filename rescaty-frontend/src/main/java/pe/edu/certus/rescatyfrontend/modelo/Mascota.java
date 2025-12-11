package pe.edu.certus.rescatyfrontend.modelo;

public class Mascota {

    private Long id;
    private String nombre;
    private String especie;
    private String raza;
    private String sexo;
    private Integer edadMeses;
    private String salud;
    private String estado;
    private String creadoEn;

    public Mascota() {
    }

    public Mascota(Long id, String nombre, String especie, String raza, String sexo, Integer edadMeses, String salud,
			String estado, String creadoEn) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.edadMeses = edadMeses;
		this.salud = salud;
		this.estado = estado;
		this.creadoEn = creadoEn;
	}

	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getEdadMeses() {
        return edadMeses;
    }
    public void setEdadMeses(Integer edadMeses) {
        this.edadMeses = edadMeses;
    }

    public String getSalud() {
        return salud;
    }
    public void setSalud(String salud) {
        this.salud = salud;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCreadoEn() {
        return creadoEn;
    }
    public void setCreadoEn(String creadoEn) {
        this.creadoEn = creadoEn;
    }
}
