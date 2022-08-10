package Core.Service;

import java.util.List;

import Core.BO.ClientBO;
import Core.BO.FuncionarioBO;
import Core.Entity.FuncionarioEntity;
import Core.Exception.RegraNegocioException;

public class FuncionarioService {

	 public String salvarFuncionario(FuncionarioEntity funcionario) throws RegraNegocioException { 
	    	return new FuncionarioBO().salvarFuncionario(funcionario);
	    } 
	 
	 public String removerFuncioario(Long id) throws RegraNegocioException {	    
	    	return new FuncionarioBO().removerFuncionario(id);
	    }
	    
	    public String atualizarFuncionario(FuncionarioEntity funcionario) throws RegraNegocioException {
	    	return new FuncionarioBO().atualizarFuncioario(funcionario);
	    }
	    
	    public List<FuncionarioEntity> listarFuncionarios() throws RegraNegocioException {
	    	return new FuncionarioBO().listarFuncionarios();
	    }
	    
	    public FuncionarioEntity buscarPorId(Long id) throws RegraNegocioException {
	    	return new FuncionarioBO().buscarPorId(id);
	    }
}
