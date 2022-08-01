package Core.Entity;

public class NotaServicoEntity {
    
    private ClienteEntity cliente;

    private VeiculoEntity veiculoAlugado;

    private int diasAlugados;
    
    public NotaServicoEntity() {
		
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public VeiculoEntity getVeiculoAlugado() {
		return veiculoAlugado;
	}

	public void setVeiculoAlugado(VeiculoEntity veiculoAlugado) {
		this.veiculoAlugado = veiculoAlugado;
	}

	public int getDiasAlugados() {
		return diasAlugados;
	}

	public void setDiasAlugados(int diasAlugados) {
		this.diasAlugados = diasAlugados;
	}
    
    
    
}
