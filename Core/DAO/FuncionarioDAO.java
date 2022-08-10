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

public class FuncionarioDAO {

	public String salvarFuncionario(FuncionarioEntity funcionario) {
        System.out.println("cadastrando no banco de dados...");
        Connection con = ConexaoBancoMySql.getConexao();
		String sql = "INSERT INTO funcionario (nome, cpf, email,telefone, salario) VALUES (?,?,?,?,?)" ;
        
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getCPF());
			stmt.setString(3, funcionario.getEmail());
			stmt.setString(4, funcionario.getTelefone());
			stmt.setDouble(5, funcionario.getSalario());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
        return "Funcionario cadastrado com sucesso no banco de dados";
    }
	
	public String removerFuncioario(Long id) {
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "DELETE FROM funcionario WHERE id=?" ;
		
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, id.toString());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Erro na exclusão do funcionario.";
		}
		
		return "Funcionario deletado com sucesso!";
	}

	public String atualizarFuncionario(FuncionarioEntity funcionario) {
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "UPDATE funcionario SET nome=?, cpf=?, email=?,telefone=?,salario=? WHERE id=?  ";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getCPF());
			stmt.setString(3, funcionario.getEmail());
			stmt.setString(4, funcionario.getTelefone());
			stmt.setDouble(5, funcionario.getSalario());
			stmt.setLong(6, funcionario.getId());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return "Erro na atualização do funcionario.";
		}
		
		return "Funcionario atualizado com sucesso!";
	}
	
	
	public List<FuncionarioEntity> listarFuncionario() {
		List<FuncionarioEntity> funcionarios = new ArrayList<FuncionarioEntity>();
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "SELECT id,nome,cpf,telefone,email,salario FROM funcionario" ;
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				FuncionarioEntity f = new FuncionarioEntity();
				f.setId(rs.getLong("id"));
				f.setNome(rs.getString("nome"));
				f.setCPF(rs.getString("cpf"));
				f.setEmail(rs.getString("email"));
				f.setTelefone(rs.getString("telefone"));
				f.setSalario(rs.getDouble("salario"));
				funcionarios.add(f);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return funcionarios;
		
	}
	
	
	public FuncionarioEntity buscarPorId(Long id) {
		FuncionarioEntity funcionario = new FuncionarioEntity();
		Connection con = ConexaoBancoMySql.getConexao();
		String sql = "SELECT id,nome,cpf,telefone,email,salario FROM funcionario WHERE id=?";
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				funcionario.setId(rs.getLong("id"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setCPF(rs.getString("cpf"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setSalario(rs.getDouble("salario"));
			}
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return funcionario;
	}
	
	
}
