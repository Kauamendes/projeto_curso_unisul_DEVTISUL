package Core.BO;

import java.util.List;

import Core.DAO.NotaServicoDAO;
import Core.Entity.NotaServicoEntity;



public class NotaServicoBO {

	public String salvarNotaServico(NotaServicoEntity nota) {
	     return new NotaServicoDAO().salvarNotaServico(nota);
	 }
	 
	 public String removerNotaServico(Long id) {
	     return new NotaServicoDAO().removerNotaServico(id);
		
	}

	public String atualizarNotaServico(NotaServicoEntity nota) {
		 return new NotaServicoDAO().atualizarNotaServico(nota);
	}
	
	public List<NotaServicoEntity> listarNotaServico() {
		return new NotaServicoDAO().listarNotasServico();
	}
	
	public NotaServicoEntity buscarPorId(Long id) {
		return new NotaServicoDAO().buscarPorId(id);
	}
	
}
