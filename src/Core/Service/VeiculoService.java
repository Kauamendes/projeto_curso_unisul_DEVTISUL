package Core.Service;

import java.util.List;

import Core.BO.ClientBO;
import Core.BO.FuncionarioBO;
import Core.BO.VeiculoBO;
import Core.Entity.ClienteEntity;
import Core.Entity.FuncionarioEntity;
import Core.Entity.VeiculoEntity;

public class VeiculoService {

	public String salvarVeiculo(VeiculoEntity veiculo) {
		return new VeiculoBO().salvarVeiculo(veiculo);
	}
	
	public String removerVeiculo(Long id) {
    	return new VeiculoBO().removerVeiculo(id);
    }
    
    public String atualizarVeiculo(VeiculoEntity veiculo) {
    	return new VeiculoBO().atualizarVeiculo(veiculo);
    }
    
    public List<VeiculoEntity> listarVeiculos() {
    	return new VeiculoBO().listarVeiculos();
    }
    
    public VeiculoEntity buscarPorId(Long id) {
    	return new VeiculoBO().buscarPorId(id);
    }
	
}
