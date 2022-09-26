package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class DestinosDAO {

	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rset = null;

	public void save(Destino destino) {
		String sql = "INSERT INTO destinos (cidade, pais)" + "VALUES (?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, destino.getCidade());
			pstm.setString(2, destino.getPais());
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
	public void update(Destino destino) {
		String sql = "UPDATE destinos SET cidade = ?, pais = ?" + "WHERE idDestino = ?";
		

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, destino.getCidade());
			pstm.setString(2, destino.getPais());
			pstm.setInt(3, destino.getIdDestino());
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
	public List<Destino> getDestino() {
		String sql = "SELECT * FROM destinos";
		
		List<Destino> destino = new ArrayList<Destino>();

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Destino destinos = new Destino();
				
				destinos.setCidade(rset.getString("cidade"));
				destinos.setPais(rset.getString("pais"));
				destinos.setIdDestino(rset.getInt("idDestino"));
				destino.add(destinos);
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

		return destino;
	}
	public Destino buscarID(int id) {
		String sql = "SELECT * FROM destinos WHERE idDestino = ?";
		Destino destinos = new Destino();
	
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			destinos.setCidade(rset.getString("cidade"));
			destinos.setPais(rset.getString("pais"));
			destinos.setIdDestino(rset.getInt("idDestino"));
			
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
		return destinos;
	}
	public void removeById(int id) {
		String sql = "DELETE FROM destinos WHERE idDestino = ?";
		
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
