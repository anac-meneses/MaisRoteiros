package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import modelo.Cliente;
import modelo.Compra;
import modelo.Pacotes;

public class CompraDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rset = null;

	public void save(Compra compra) {
		String sql = "INSERT INTO compra (valor, dataCompra, quantidade, cpf, idPacote )" + "VALUES (?,?,?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setDouble(1, compra.getValor());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(2, new Date(formatter.parse(compra.getDataCompra()).getTime()));
			pstm.setInt(3, compra.getQuantidade());
			pstm.setString(4, compra.getCliente().getCpf());
			pstm.setInt(5, compra.getPacotes().getIdPacote());
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

	public void update(Compra compra) {
		String sql = "UPDATE compra SET valor= ?, dataCompra = ?, quantidade = ?, cpf = ?, idPacote = ? WHERE idCompra = ?";
		

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setDouble(1, compra.getValor());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			pstm.setDate(2, new Date(formatter.parse(compra.getDataCompra()).getTime()));
			pstm.setInt(3, compra.getQuantidade());
			pstm.setString(4, compra.getCliente().getCpf());
			pstm.setInt(5, compra.getPacotes().getIdPacote());
			pstm.setInt(6, compra.getIdCompra());
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

	public List<Compra> getCompra(){
		String sql = "SELECT * FROM compras";		
		List<Compra> compra = new ArrayList<Compra>();
		
		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Compra compras= new Compra();
				Cliente cliente= new Cliente();
				Pacotes pacote=new Pacotes();
				
				compras.setValor(rset.getDouble("valor"));
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				compras.setDataCompra(formatter.format(rset.getDate("dataCompra")));
				compras.setIdCompra(rset.getInt("idCompra"));
				compras.setQuantidade(rset.getInt("quantidade"));
				cliente.setCpf(rset.getString("cpf"));
				compras.setCliente(cliente);
				pacote.setIdPacote(rset.getInt("idPacote"));
				compras.setPacotes(pacote);
				compra.add(compras);
				
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

		
		
		
		return compra;

	};

	public Compra buscarID(int id) {
		String sql = "SELECT * FROM compras WHERE idCompra = ?";
		Compra compras = new Compra();
		Cliente cliente= new Cliente();
		Pacotes pacote=new Pacotes();
		
	
			
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			rset.next();
			compras.setValor(rset.getDouble("valor"));
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			compras.setDataCompra(formatter.format(rset.getDate("dataCompra")));
			compras.setIdCompra(rset.getInt("idCompra"));
			compras.setQuantidade(rset.getInt("quantidade"));
			cliente.setCpf(rset.getString("cpf"));
			compras.setCliente(cliente);
			pacote.setIdPacote(rset.getInt("idPacote"));
			compras.setPacotes(pacote);
			
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
		return compras;
	}

	public void removeById(int id) {
		String sql = "DELETE FROM compra WHERE idCompra = ?";
		
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
