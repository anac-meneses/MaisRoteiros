package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Login;
import modelo.LoginDAO;

@WebServlet(urlPatterns = { "/ClienteLista", "/ClienteCadastro", "/CadastroClienteADM", "/ClienteUpdate", "/ClienteEdit",
		"/ClienteDel" })
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ClienteDAO cliDAO = new ClienteDAO();
	Cliente cliente = new Cliente();
	LoginDAO log = new LoginDAO();
	Login l = new Login();
	public ClienteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/ClienteLista":
			read(request, response);
			break;
		case "/ClienteCadastro":
			create1(request, response);
			break;
		case "/CadastroClienteADM":
			create2(request, response);
			break;
		case "/ClienteUpdate":
			update(request, response);
			break;
		case "/ClienteEdit":
			edit(request, response);
			break;
		case "/ClienteDel":
			delet(request, response);
			break;

		default:
			response.sendRedirect("Home.html");
			break;
		}
	}

	// READ
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Cliente> lista = new ArrayList<Cliente>();
			lista =	cliDAO.getCliente();
			
			request.setAttribute("lista", lista);
			RequestDispatcher rd = request.getRequestDispatcher("./crud/clienteLista.jsp");
		rd.forward(request, response);
	}

	protected void create1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cliente.setCpf(request.getParameter("cpf"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setSenha(request.getParameter("senha"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setLogin(log.buscarID(3)); /* o id 3 é de usuario */
		cliDAO.save(cliente);

		response.sendRedirect("Home.html");

	}

	protected void create2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		cliente.setCpf(request.getParameter("cpf"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setSenha(request.getParameter("senha"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setLogin(log.buscarID(2)); /* o id 2 é adm */
		cliDAO.save(cliente);
		response.sendRedirect("ClienteLista");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpfUpdate = request.getParameter("cpf");
		cliente = cliDAO.buscarID(cpfUpdate);
		request.setAttribute("cpf", cliente.getCpf());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("email", cliente.getEmail());
		request.setAttribute("senha", cliente.getSenha());
		request.setAttribute("telefone", cliente.getTelefone());
		request.setAttribute("login", cliente.getLogin());
		RequestDispatcher rd = request.getRequestDispatcher("./crud/clienteUpdate.jsp");
		rd.forward(request, response);
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setSenha(request.getParameter("senha"));
		cliente.setTelefone(request.getParameter("telefone"));
		l.setIdLogin(Integer.parseInt(request.getParameter("login")));
		cliente.setLogin(l);
		cliDAO.update(cliente);
		response.sendRedirect("ClienteLista");
		}

	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		cliDAO.removeById(request.getParameter("cpf"));
		response.sendRedirect("ClienteLista");
	}

}
