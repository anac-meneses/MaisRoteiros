package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LoginDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rset = null;

	public void save(Login login) {
		String sql = "INSERT INTO login (tipo_permissao)" + "VALUES (?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, login.getTipoLogin());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(Login login) {
		String sql = "UPDATE login SET tipo_permissao = ?" + "WHERE idLogin = ?";
		

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, login.getTipoLogin());
			pstm.setInt(2, login.getIdLogin());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Login> getLogin(){
		String sql = "SELECT * FROM login";		
		List<Login> logs = new ArrayList<Login>();
		
		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Login login = new Login();
				login.setTipoLogin(rset.getString("tipo_permissao"));
				login.setIdLogin(rset.getInt("IdLogin"));
				logs.add(login);
				
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	
	return logs;
};
	
	public Login buscarID(int id) {
	String sql = "SELECT * FROM login WHERE Idlogin = ?";
	Login login = new Login();
	
	try {
		conn = Conexao.createConnectionToMySQL();
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rset = pstm.executeQuery();
		rset.next();
		login.setTipoLogin(rset.getString("tipo_permissao"));
		login.setIdLogin(rset.getInt("IdLogin"));
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return login;
}
	
	public void removeById(int id) {
		String sql = "DELETE FROM login WHERE idLogin = ?";
		
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
