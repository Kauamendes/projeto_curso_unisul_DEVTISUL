package Core.BO;

import java.util.List;

import Core.DAO.FuncionarioDAO;
import Core.DAO.VeiculoDAO;
import Core.Entity.FuncionarioEntity;
import Core.Entity.VeiculoEntity;

public class VeiculoBO {

	public String salvarVeiculo(VeiculoEntity veiculo) {
		return new VeiculoDAO().salvarVeiculo(veiculo);
	}
	
	public String removerVeiculo(Long id) {
		 return new VeiculoDAO().removerVeiculo(id);
		
	}

	public String atualizarVeiculo(VeiculoEntity veiculo) {
		return new VeiculoDAO().atualizarVeiculo(veiculo);
	}
	
	public List<VeiculoEntity> listarVeiculos() {
		return new VeiculoDAO().listarVeiculos();
	}
	
	public VeiculoEntity buscarPorId(Long id) {
		return new VeiculoDAO().buscarPorId(id);
	}
	
}
