package Core.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Core.DAO.connection.ConexaoBancoMySql;
import Core.Entity.ClienteEntity;
import Core.Exception.RegraNegocioException;

public class ClienteDAO {
    
	public ClienteEntity buscarPorId(Long id) {
		ClienteEntity cliente = new ClienteEntity();
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "SELECT id,nome,cpf,telefone,email,carteira_motorista FROM cliente WHERE id=?";
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCPF(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setTelefone(rs.getString("telefone"));
				cliente.setCarteiraMotorista(rs.getString("carteira_motorista"));
			}
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return cliente;
	}
	
	public ClienteEntity buscarClientePorCpf(String cpf) {
		ClienteEntity cliente = new ClienteEntity();
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "SELECT id,nome,cpf,email,telefone,carteira_motorista FROM cliente WHERE cpf=?";
		

			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, cpf);
				ResultSet rs = stmt.executeQuery();
				
				
				if(rs.next()) {
					cliente.setId(rs.getLong("id"));
					cliente.setNome(rs.getString("nome"));
					cliente.setCPF(rs.getString("cpf"));
					cliente.setEmail(rs.getString("email"));
					cliente.setTelefone(rs.getString("telefone"));
					cliente.setCarteiraMotorista(rs.getString("carteira_motorista"));
				}
				
				stmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return cliente;
	}
	
    public String salvarCliente(ClienteEntity client) {
        System.out.println("cadastrando no banco de dados...");
        Connection con = ConexaoBancoMySql.getConexao();
		String sql = "INSERT INTO cliente (nome, cpf, email,telefone, carteira_motorista) VALUES (?,?,?,?,?)" ;
        
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, client.getNome());
			stmt.setString(2, client.getCPF());
			stmt.setString(3, client.getEmail());
			stmt.setString(4, client.getTelefone());
			stmt.setString(5, client.getCarteiraMotorista());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
        return "Cliente cadastrado com sucesso no banco de dados";
    }

	public String removerCliente(Long id) {
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "DELETE FROM cliente WHERE id=?" ;
		
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id.toString());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Erro na exclusão do cliente.";
		}
		
		return "Cliente deletado com sucesso!";
	}

	public String atualizarCliente(ClienteEntity cliente) {
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "UPDATE cliente SET nome=?, cpf=?, email=?,telefone=?,carteira_motorista=? WHERE id=? " ;
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCPF());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getCarteiraMotorista());
			stmt.setLong(6, cliente.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Erro na atualização do cliente.";
		}
		
		return "Cliente atualizado com sucesso!";
	}

	public List<ClienteEntity> listarClientes() {
		List<ClienteEntity> clientes = new ArrayList<ClienteEntity>();
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "SELECT id,nome,cpf,telefone,email,carteira_motorista FROM cliente" ;
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				ClienteEntity c = new ClienteEntity();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setCPF(rs.getString("cpf"));
				c.setEmail(rs.getString("email"));
				c.setTelefone(rs.getString("telefone"));
				c.setCarteiraMotorista(rs.getString("carteira_motorista"));
				clientes.add(c);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return clientes;
	}
    
}
