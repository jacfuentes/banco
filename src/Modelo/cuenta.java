package Modelo;

public final class cuenta {
	private Integer cueId;
	private Integer cueSaldo;
	private String cueFecApertura;
	private String cueEstado;
	private Integer cueSobreGiro;
	private cliente cliente;
	
	public cuenta() {
		super();
	}

	public cuenta(Integer cueId, Integer cueSaldo, String cueFecApertura, String cueEstado, Integer cueSobreGiro,
			Modelo.cliente cliente) {
		super();
		this.cueId = cueId;
		this.cueSaldo = cueSaldo;
		this.cueFecApertura = cueFecApertura;
		this.cueEstado = cueEstado;
		this.cueSobreGiro = cueSobreGiro;
		this.cliente = cliente;
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

	public Integer getCueSobreGiro() {
		return cueSobreGiro;
	}

	public void setCueSobreGiro(Integer cueSobreGiro) {
		this.cueSobreGiro = cueSobreGiro;
	}

	public cliente getCliente() {
		return cliente;
	}

	public void setCliente(cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "cuenta [cueId=" + cueId + ", cueSaldo=" + cueSaldo + ", cueFecApertura=" + cueFecApertura
				+ ", cueEstado=" + cueEstado + ", cueSobreGiro=" + cueSobreGiro + ", cliente=" + cliente + "]";
	}

	
	
}	