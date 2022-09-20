package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rset = null;

	public void save(Cliente cliente) {
		String sql = "INSERT INTO cliente (cpf, telefone, nome, email, senha, idLogin)" + "VALUES (?,?,?,?,?,?)";

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getCpf() );
			pstm.setString(2, cliente.getTelefone());
			pstm.setString(3, cliente.getNome());
			pstm.setString(4, cliente.getEmail());
			pstm.setString(5, cliente.getSenha());
			pstm.setInt(6, cliente.getLogin().getIdLogin());
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

	public void update(Cliente cliente) {
		String sql = "UPDATE cliente SET telefone = ?, nome = ?, email = ?, senha = ?, idLogin = ? WHERE cpf = ?;";
		

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getTelefone());
			pstm.setString(2, cliente.getNome());
			pstm.setString(3, cliente.getEmail());
			pstm.setString(4, cliente.getSenha());
			pstm.setInt(5, cliente.getLogin().getIdLogin());
			pstm.setString(6, cliente.getCpf());
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

	public List<Cliente> getCliente(){
		String sql = "SELECT * FROM cliente";		
		List<Cliente> cliente = new ArrayList<Cliente>();
		
		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente clientes = new Cliente();
				Login login = new Login();
				clientes.setCpf(rset.getString("cpf"));
				clientes.setEmail(rset.getString("email"));
				clientes.setNome(rset.getString("nome"));
				clientes.setTelefone(rset.getString("telefone"));
				clientes.setSenha(rset.getString("senha"));
				login.setIdLogin(rset.getInt("idLogin"));
				clientes.setLogin(login);
				cliente.add(clientes);
				
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

		
		
		
		return cliente;

	};

	public Cliente buscarID(String cpf) {
		String sql = "SELECT * FROM cliente WHERE cpf = ?";
		Cliente clientes = new Cliente();
		Login login = new Login();
			
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cpf);
			rset = pstm.executeQuery();
			rset.next();
			clientes.setCpf(rset.getString("cpf"));
			clientes.setEmail(rset.getString("email"));
			clientes.setNome(rset.getString("nome"));
			clientes.setTelefone(rset.getString("telefone"));
			clientes.setSenha(rset.getString("senha"));
			login.setIdLogin(rset.getInt("idLogin"));
			clientes.setLogin(login);
			
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
		return clientes;
	}

	public void removeById(String cpf) {
		String sql = "DELETE FROM cliente WHERE cpf = ?";
		
		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cpf);
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
