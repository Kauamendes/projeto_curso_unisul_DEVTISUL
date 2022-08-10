package Core.Entity;

public class ClienteEntity extends PessoaEntity {
    
    private String carteiraMotorista;

    public ClienteEntity() {
		
	}

	public ClienteEntity(String carteiraMotorista) {
		super();
		this.carteiraMotorista = carteiraMotorista;
	}

	public String getCarteiraMotorista() {
		return carteiraMotorista;
	}

	public void setCarteiraMotorista(String carteiraMotorista) {
		this.carteiraMotorista = carteiraMotorista;
	}
    
    
    
}
