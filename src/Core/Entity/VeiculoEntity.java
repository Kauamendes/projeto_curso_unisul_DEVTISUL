package Core.Entity;

import java.util.Objects;

public class VeiculoEntity {
    
    private Long id;

    private String modelo;

    private String marca;

    private String placa;
    
    private Double valorDiaria;

    private String cor;

    private int lugares;

    private boolean alugado;

    private String carteiraExigida;

	public VeiculoEntity() {
		super();
	}

	public VeiculoEntity(Long id, String modelo, String marca, String placa, Double valorDiaria, String cor,
			int lugares, boolean alugado, String carteiraExigida) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.placa = placa;
		this.valorDiaria = valorDiaria;
		this.cor = cor;
		this.lugares = lugares;
		this.alugado = alugado;
		this.carteiraExigida = carteiraExigida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getLugares() {
		return lugares;
	}

	public void setLugares(int lugares) {
		this.lugares = lugares;
	}

	public boolean isAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}

	public String getCarteiraExigida() {
		return carteiraExigida;
	}

	public void setCarteiraExigida(String carteiraExigida) {
		this.carteiraExigida = carteiraExigida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VeiculoEntity other = (VeiculoEntity) obj;
		return Objects.equals(id, other.id);
	}
    
    
    
}
