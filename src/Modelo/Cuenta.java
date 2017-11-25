package Modelo;

public final class Cuenta {
	private Integer cueId;
	private Integer cueSaldo;
	private String cueFecApertura;
	private String cueEstado;
	private int cueSobreGiro;
	private Cliente Cli;
	
	public Cuenta(Cliente cli) { super();
	}

	public Cuenta(Integer cueId, Integer cueSaldo, String cueFecApertura, String cueEstado, int cueSobreGiro,
			Cliente cli) {
		this.cueId = cueId;
		this.cueSaldo = cueSaldo;
		this.cueFecApertura = cueFecApertura;
		this.cueEstado = cueEstado;
		this.cueSobreGiro = cueSobreGiro;
		Cli = cli;
	}

	public Integer getCueId() {
		return cueId;
	}

	public void setCueId(Integer cueId) {
		this.cueId = cueId;
	}

	public Integer getCueSaldo() {
		return cueSaldo;
	}

	public void setCueSaldo(Integer cueSaldo) {
		this.cueSaldo = cueSaldo;
	}

	public String getCueFecApertura() {
		return cueFecApertura;
	}

	public void setCueFecApertura(String cueFecApertura) {
		this.cueFecApertura = cueFecApertura;
	}

	public String getCueEstado() {
		return cueEstado;
	}

	public void setCueEstado(String cueEstado) {
		this.cueEstado = cueEstado;
	}

	public int getCueSobreGiro() {
		return cueSobreGiro;
	}

	public void setCueSobreGiro(int cueSobreGiro) {
		this.cueSobreGiro = cueSobreGiro;
	}

	public Cliente getCli() {
		return Cli;
	}

	public void setCli(Cliente cli) {
		Cli = cli;
	}

	@Override
	public String toString() {
		return "Cuenta [cueId=" + cueId + ", cueSaldo=" + cueSaldo + ", cueFecApertura=" + cueFecApertura
				+ ", cueEstado=" + cueEstado + ", cueSobreGiro=" + cueSobreGiro + ", Cli=" + Cli + "]";
	}

	
	
	
}	