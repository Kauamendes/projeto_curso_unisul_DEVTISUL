package Core.BO;

import java.util.List;

import Core.DAO.ClienteDAO;
import Core.Entity.ClienteEntity;
import Core.Exception.RegraNegocioException;

public class ClientBO {
    
	private void validaCliente(ClienteEntity cliente) throws RegraNegocioException {
		if(!cliente.getEmail().contains("@")) {
	         throw new RegraNegocioException("Email invalido");
	      }
	      
	      if(cliente.getNome() != null && cliente.getNome().equals("")) {
	    	  throw new RegraNegocioException("Nome n�o pode ser vazio");
	      }
	      
	      if(verificaCpfExistenteNoBanco(cliente.getCPF())) {
	    	  throw new RegraNegocioException("CPF j� existente no banco de dados");
	      }
		
	}
	
	public boolean verificaCpfExistenteNoBanco(String cpf) {
		ClienteDAO dao = new ClienteDAO();
		ClienteEntity cliente = dao.buscarClientePorCpf(cpf);
		
		if(cliente.getId() != null) { 
			return true;
		} else {
			return false;
		}
	}
	
    public String salvarCliente(ClienteEntity cliente) throws RegraNegocioException {
    		validaCliente(cliente);
    		ClienteDAO dao = new ClienteDAO();
    		return dao.salvarCliente(cliente);
      }

	public String removerCliente(Long id) {
		 ClienteDAO dao = new ClienteDAO();
	     return dao.removerCliente(id);
		
	}

	public String atualizarCliente(ClienteEntity cliente) throws RegraNegocioException {
		 ClienteDAO dao = new ClienteDAO();
	     return dao.atualizarCliente(cliente);
	}

	public List<ClienteEntity> listarClientes() {
		ClienteDAO dao = new ClienteDAO();
		return dao.listarClientes();
	}
	
	public ClienteEntity buscarPorId(Long id) {
		return new ClienteDAO().buscarPorId(id);
	}
	
}
