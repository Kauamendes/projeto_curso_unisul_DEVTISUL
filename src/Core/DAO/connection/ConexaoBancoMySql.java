package Core.DAO.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBancoMySql {

	private static final String urlDb = "jdbc:mysql://localhost:3306/locadora";
	private static final String user = "root";
	private static final String password = "brt2016brt";
	
	private static Connection conn;
	
	public static Connection getConexao() {
		
			try {
				if(conn == null) {
				conn = DriverManager.getConnection(urlDb, user, password);
				return conn;
				} else {
					return conn;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}	
	}
	
	public static void main(String[] args) {
		
		
		
		
//METODO TESTE		
//		try {
//			Connection con = DriverManager.getConnection(urlDb, user, password);
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery(" SELECT nome FROM cliente ");
//			while(rs.next()) {
//				System.out.println(rs.getString("nome"));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
}
