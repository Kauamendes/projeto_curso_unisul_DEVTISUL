package Core.BO;

import java.util.List;

import Core.DAO.ClienteDAO;
import Core.DAO.FuncionarioDAO;
import Core.Entity.ClienteEntity;
import Core.Entity.FuncionarioEntity;

public class FuncionarioBO {

	 public String salvarFuncionario(FuncionarioEntity funcionario) {
	     return new FuncionarioDAO().salvarFuncionario(funcionario);
	 }
	 
	 public String removerFuncionario(Long id) {
	     return new FuncionarioDAO().removerFuncioario(id);
		
	}

	public String atualizarFuncioario(FuncionarioEntity funcionario) {
		 return new FuncionarioDAO().atualizarFuncionario(funcionario);
	}
	
	public List<FuncionarioEntity> listarFuncionarios() {
		return new FuncionarioDAO().listarFuncionario();
	}
	
	public FuncionarioEntity buscarPorId(Long id) {
		return new FuncionarioDAO().buscarPorId(id);
	}
	
}
