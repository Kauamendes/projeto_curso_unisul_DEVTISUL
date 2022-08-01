package Core.Entity;

public class FuncionarioEntity extends PessoaEntity {

    private Double salario;
  
    public FuncionarioEntity() {
		
	}

	public FuncionarioEntity(Double salario) {
		super();
		this.salario = salario;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
    
    
    
}
