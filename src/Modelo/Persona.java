package Modelo;

public abstract class Persona {
	private String perRut;
	private String perNombre;
	private String perApePaterno;
	private String perApeMaterno;
	private String perNacionalidad;
	private String perFecNacimiento;
	
	public Persona() {
	}

	public Persona(String perRut, String perNombre, String perApePaterno, String perApeMaterno, String perNacionalidad,
			String perFecNacimiento) {
		this.perRut = perRut;
		this.perNombre = perNombre;
		this.perApePaterno = perApePaterno;
		this.perApeMaterno = perApeMaterno;
		this.perNacionalidad = perNacionalidad;
		this.perFecNacimiento = perFecNacimiento;
	}

	public String getPerRut() {
		return perRut;
	}

	public void setPerRut(String perRut) {
		this.perRut = perRut;
	}

	public String getPerNombre() {
		return perNombre;
	}

	public void setPerNombre(String perNombre) {
		this.perNombre = perNombre;
	}

	public String getPerApePaterno() {
		return perApePaterno;
	}

	public void setPerApePaterno(String perApePaterno) {
		this.perApePaterno = perApePaterno;
	}

	public String getPerApeMaterno() {
		return perApeMaterno;
	}

	public void setPerApeMaterno(String perApeMaterno) {
		this.perApeMaterno = perApeMaterno;
	}

	public String getPerNacionalidad() {
		return perNacionalidad;
	}

	public void setPerNacionalidad(String perNacionalidad) {
		this.perNacionalidad = perNacionalidad;
	}

	public String getPerFecNacimiento() {
		return perFecNacimiento;
	}

	public void setPerFecNacimiento(String perFecNacimiento) {
		this.perFecNacimiento = perFecNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [perRut=" + perRut + ", perNombre=" + perNombre + ", perApePaterno=" + perApePaterno
				+ ", perApeMaterno=" + perApeMaterno + ", perNacionalidad=" + perNacionalidad + ", perFecNacimiento="
				+ perFecNacimiento + "]";
	}
	
	
	
}
