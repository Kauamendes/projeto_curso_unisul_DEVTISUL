package Core.Service;

import java.util.List;
import Core.BO.NotaServicoBO;
import Core.Entity.NotaServicoEntity;
import Core.Exception.RegraNegocioException;

public class NotaServicoService {

	public String salvarNotaServico(NotaServicoEntity nota) throws RegraNegocioException {
	     return new NotaServicoBO().salvarNotaServico(nota);
	 }
	 
	 public String removerNotaServico(Long id) throws RegraNegocioException {
	     return new NotaServicoBO().removerNotaServico(id);
		
	}

	public String atualizarNotaServico(NotaServicoEntity nota) throws RegraNegocioException {
		 return new NotaServicoBO().atualizarNotaServico(nota);
	}
	
	public List<NotaServicoEntity> listarNotaServico() throws RegraNegocioException {
		return new NotaServicoBO().listarNotaServico();
	}
	
	public NotaServicoEntity buscarPorId(Long id) throws RegraNegocioException {
		return new NotaServicoBO().buscarPorId(id);
	}
	
}
