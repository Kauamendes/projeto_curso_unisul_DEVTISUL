package Core.Service;

import java.util.List;

import Core.BO.ClientBO;
import Core.BO.FuncionarioBO;
import Core.Entity.FuncionarioEntity;

public class FuncionarioService {

	 public String salvarFuncionario(FuncionarioEntity funcionario) { 
	    	return new FuncionarioBO().salvarFuncionario(funcionario);
	    } 
	 
	 public String removerFuncioario(Long id) {	    
	    	return new FuncionarioBO().removerFuncionario(id);
	    }
	    
	    public String atualizarFuncionario(FuncionarioEntity funcionario) {
	    	return new FuncionarioBO().atualizarFuncioario(funcionario);
	    }
	    
	    public List<FuncionarioEntity> listarFuncionarios() {
	    	return new FuncionarioBO().listarFuncionarios();
	    }
	    
	    public FuncionarioEntity buscarPorId(Long id) {
	    	return new FuncionarioBO().buscarPorId(id);
	    }
}
