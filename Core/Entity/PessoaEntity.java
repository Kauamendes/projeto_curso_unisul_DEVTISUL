
package Core.Entity;

import java.util.Objects;

public class PessoaEntity {

    private Long id;

    private String nome;

    private String CPF;

    private String telefone;
    
    private String email;

    public PessoaEntity() {
		
	}

	public PessoaEntity(Long id, String nome, String CPF, String telefone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.CPF = CPF;
		this.telefone = telefone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaEntity other = (PessoaEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(telefone, other.telefone);
	}
    
    
    
}
