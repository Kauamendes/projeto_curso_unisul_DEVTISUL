package Core.Service;

import java.util.List;

import Core.BO.ClientBO;
import Core.BO.FuncionarioBO;
import Core.BO.VeiculoBO;
import Core.Entity.ClienteEntity;
import Core.Entity.FuncionarioEntity;
import Core.Entity.VeiculoEntity;
import Core.Exception.RegraNegocioException;

public class VeiculoService {

	public String salvarVeiculo(VeiculoEntity veiculo) throws RegraNegocioException {
		return new VeiculoBO().salvarVeiculo(veiculo);
	}
	
	public String removerVeiculo(Long id) throws RegraNegocioException {
    	return new VeiculoBO().removerVeiculo(id);
    }
    
    public String atualizarVeiculo(VeiculoEntity veiculo) throws RegraNegocioException {
    	return new VeiculoBO().atualizarVeiculo(veiculo);
    }
    
    public List<VeiculoEntity> listarVeiculos() throws RegraNegocioException {
    	return new VeiculoBO().listarVeiculos();
    }
    
    public VeiculoEntity buscarPorId(Long id) throws RegraNegocioException {
    	return new VeiculoBO().buscarPorId(id);
    }
	
}
