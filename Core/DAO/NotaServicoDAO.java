package Core.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Core.DAO.connection.ConexaoBancoMySql;
import Core.Entity.ClienteEntity;
import Core.Entity.NotaServicoEntity;
import Core.Entity.VeiculoEntity;

public class NotaServicoDAO {

	public String salvarNotaServico(NotaServicoEntity nota) {
        System.out.println("cadastrando no banco de dados...");
        Connection con = ConexaoBancoMySql.getConexao();
		String sql = "INSERT INTO nota_servico (cliente_id, veiculo_id, dias_alugados) VALUES (?,?,?)";
        
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, nota.getCliente().getId());
			stmt.setLong(2, nota.getVeiculoAlugado().getId());
			stmt.setInt(3, nota.getDiasAlugados());
	
			
						
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
        return "nota de serviço cadastrado com sucesso no banco de dados";
    }
	
	
	public String removerNotaServico(Long id) {
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "DELETE FROM nota_servico WHERE id=?" ;
		
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id.toString());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Erro na exclus�o de nota de serviço.";
		}
		
		return "nota de serviço deletado com sucesso!";
	}
	
	
	public String atualizarNotaServico(NotaServicoEntity nota) {
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "UPDATE nota_servico SET cliente_id=?, veiculo_id=?, dias_alugados=? WHERE id=?  " ;
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, nota.getCliente().getId());
			stmt.setLong(2, nota.getVeiculoAlugado().getId());
			stmt.setInt(3, nota.getDiasAlugados());
			stmt.setLong(4, nota.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Erro na atualiza��o da nota de serviço.";
		}
		
		return "Nota de serviço atualizado com sucesso!";
	}

	public List<NotaServicoEntity> listarNotasServico() {
		List<NotaServicoEntity> notas = new ArrayList<NotaServicoEntity>();
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "SELECT n.id,c.nome,v.valor_diaria,v.modelo,n.dias_alugados FROM nota_servico n";
			   sql+= " LEFT JOIN cliente c on c.id = n.cliente_id ";
			   sql+= " LEFT JOIN veiculo v on v.id = n.veiculo_id ";
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				NotaServicoEntity n = new NotaServicoEntity();
				ClienteEntity c = new ClienteEntity();
				VeiculoEntity v = new VeiculoEntity();
				
				n.setId(rs.getLong("id"));
				n.setDiasAlugados(rs.getInt("dias_alugados"));
				c.setNome(rs.getString("nome"));
				v.setModelo(rs.getString("modelo"));
				v.setValorDiaria(rs.getDouble("valor_diaria"));
				
				n.setCliente(c);
				n.setVeiculoAlugado(v);
				notas.add(n);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return notas;
		
	}
	
	
	public NotaServicoEntity buscarPorId(Long id) {
		NotaServicoEntity nota = new NotaServicoEntity();
		ClienteEntity c = new ClienteEntity();
		VeiculoEntity v = new VeiculoEntity();
		
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = " SELECT n.id,c.nome, v.valor_diaria,v.modelo, n.dias_alugados FROM nota_servico n "
				+ " LEFT JOIN cliente c on c.id = n.cliente_id "
				+ " LEFT JOIN veiculo v on v.id = n.veiculo_id "
				+ " WHERE n.id=?";
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				nota.setId(rs.getLong("id"));
				nota.setDiasAlugados(rs.getInt("dias_alugados"));
				c.setNome(rs.getString("nome"));
				v.setModelo(rs.getString("modelo"));
				
				nota.setCliente(c);
				nota.setVeiculoAlugado(v);
				
			}
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return nota;
	}
	
}
