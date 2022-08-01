package Core.Service;

import java.util.List;

import Core.BO.ClientBO;
import Core.Entity.ClienteEntity;
import Core.Exception.RegraNegocioException;

public class ClientService {
	
    public String salvarCliente(ClienteEntity cliente) throws RegraNegocioException { 
        return new ClientBO().salvarCliente(cliente);
    } 
    
    public String removerCliente(Long id) {
    	return new ClientBO().removerCliente(id);
    }
    
    public String atualizarCliente(ClienteEntity cliente) throws RegraNegocioException {
    	return new ClientBO().atualizarCliente(cliente);
    }
    
    public List<ClienteEntity> listarClientes() {
    	return new ClientBO().listarClientes();
    }
    
    public ClienteEntity buscarPorId(Long id) {
    	return new ClientBO().buscarPorId(id);
    }
    
    
}
