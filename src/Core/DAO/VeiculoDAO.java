package Core.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Core.DAO.connection.ConexaoBancoMySql;
import Core.Entity.ClienteEntity;
import Core.Entity.FuncionarioEntity;
import Core.Entity.VeiculoEntity;

public class VeiculoDAO {

	public String salvarVeiculo(VeiculoEntity veiculo) {
        System.out.println("cadastrando no banco de dados...");
        Connection con = ConexaoBancoMySql.getConexao();
		String sql = "INSERT INTO veiculo (cor, marca, modelo,placa,lugares,valor_diaria,carteira_exigida) VALUES (?,?,?,?,?,?,?)";
        
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, veiculo.getCor());
			stmt.setString(2, veiculo.getMarca());
			stmt.setString(3, veiculo.getModelo());
			stmt.setString(4, veiculo.getPlaca());
			stmt.setInt(5, veiculo.getLugares());
			stmt.setDouble(6, veiculo.getValorDiaria());
			stmt.setString(7, veiculo.getCarteiraExigida());
			
						
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
        return "Veiculo cadastrado com sucesso no banco de dados";
    }
	
	
	public String removerVeiculo(Long id) {
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "DELETE FROM veiculo WHERE id=?" ;
		
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id.toString());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Erro na exclusão do veiculo.";
		}
		
		return "Veiculo deletado com sucesso!";
	}
	
	
	public String atualizarVeiculo(VeiculoEntity veiculo) {
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "UPDATE veiculo SET marca=?,cor=?,modelo=?,placa=?,carteira_exigida=?,lugares=?,valor_diaria=? WHERE id=?  " ;
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, veiculo.getMarca());
			stmt.setString(2, veiculo.getCor());
			stmt.setString(3, veiculo.getModelo());
			stmt.setString(4, veiculo.getPlaca());
			stmt.setString(5, veiculo.getCarteiraExigida());
			stmt.setInt(6, veiculo.getLugares());
			stmt.setDouble(7, veiculo.getValorDiaria());
			stmt.setLong(8, veiculo.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Erro na atualização do veiculo.";
		}
		
		return "Veiculo atualizado com sucesso!";
	}

	public List<VeiculoEntity> listarVeiculos() {
		List<VeiculoEntity> veiculos = new ArrayList<VeiculoEntity>();
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "SELECT id,marca,modelo,cor,placa FROM veiculo" ;
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				VeiculoEntity v = new VeiculoEntity();
				v.setId(rs.getLong("id"));
				v.setMarca(rs.getString("marca"));
				v.setModelo(rs.getString("modelo"));
				v.setCor(rs.getString("cor"));
				v.setPlaca(rs.getString("placa"));
				veiculos.add(v);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return veiculos;
		
	}
	
	
	public VeiculoEntity buscarPorId(Long id) {
		VeiculoEntity veiculo = new VeiculoEntity();
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "SELECT id,marca,modelo,placa,cor,carteira_exigida,valor_diaria,lugares,alugado FROM veiculo WHERE id=?";
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setCor(rs.getString("cor"));
				veiculo.setCarteiraExigida(rs.getString("carteira_exigida"));
				veiculo.setLugares(rs.getInt("lugares"));
				veiculo.setValorDiaria(rs.getDouble("valor_diaria"));
				
			}
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return veiculo;
	}

}
