package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacotesDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rset = null;


	public void save(Pacotes pacotes) {
		String sql = "INSERT INTO pacotes (translado, hotel, qtNoites, idDestino, preco)" + "VALUES (?,?,?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pacotes.getTranslado());
			pstm.setString(2, pacotes.getHotel());
			pstm.setString(3, pacotes.getQtNoites());
			pstm.setInt(4, pacotes.getDestino().getIdDestino());
			pstm.setInt(5, pacotes.getPreco());
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
	
	public void update(Pacotes pacotes) {
		String sql = "UPDATE pacotes SET translado = ?, hotel = ?, qtNoites = ?, idDestino = ?, preco = ? WHERE idPacote = ?";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pacotes.getTranslado());
			pstm.setString(2, pacotes.getHotel());
			pstm.setString(3, pacotes.getQtNoites());
			pstm.setInt(4, pacotes.idDestino());
			pstm.setInt(5, pacotes.getPreco());
			pstm.setInt(6, pacotes.getIdPacote());
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

	public List<Pacotes> getPacotes(){
		
		String sql = "SELECT * FROM destino";
		List<Pacotes> pacote = new ArrayList<Pacotes>();
		
		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Pacotes pacotes = new Pacotes();
				Destino destino = new Destino();
				pacotes.setTranslado(rset.getString("translado"));
				pacotes.setHotel(rset.getString("hotel"));
				pacotes.setQtNoites(rset.getString("qtNoites"));
				pacotes.setIdPacote(rset.getInt("idPacote"));
				pacotes.setPreco(rset.getInt("preco"));
				destino.setIdDestino(rset.getInt("destino"));
				destino.setPais(rset.getString("pais"));
				pacotes.setDestino(destino);
				pacote.add(pacotes);			
				
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
		return pacote;
	};
	
	public Pacotes buscarID(int id) {
		String sql = "SELECT * FROM pacotes WHERE idPacote = ?";
		Pacotes pacotes = new Pacotes();
		Destino destino = new Destino();
	
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			pacotes.setTranslado(rset.getString("translado"));
			pacotes.setHotel(rset.getString("hotel"));
			pacotes.setQtNoites(rset.getString("qtNoites"));
			pacotes.setIdPacote(rset.getInt("idPacote"));
			destino.setIdDestino(rset.getInt("idDestino"));
			pacotes.setDestino(destino);
			pacotes.setPreco(rset.getInt("preco"));
			
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
		return pacotes;
	}
	
	public void removeById(int id) {
		String sql = "DELETE FROM pacotes WHERE idPacote = ?";
		
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
