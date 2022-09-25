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
import modelo.Compra;
import modelo.CompraDAO;
import modelo.Pacotes;
import modelo.PacotesDAO;

@WebServlet(urlPatterns = { "/CompraCadastro", "/CompraLista", "/CompraUpdate", "/CompraEdit", "/CompraDel" })
public class ComprasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Compra compra = new Compra();
	CompraDAO cDAO = new CompraDAO();
	Pacotes pacote = new Pacotes();
	PacotesDAO pDAO = new PacotesDAO();
	Cliente cliente = new Cliente();

	public ComprasServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/CompraCadastro":
			create(request, response);
			break;
		case "/CompraLista":
			read(request, response);
			break;
		case "/CompraUpdate":
			update(request, response);
			break;
		case "/CompraEdit":
			edit(request, response);
			break;
		case "/CompraDel":
			delet(request, response);
			break;
		default:
			response.sendRedirect("Home.html");
			break;
		}
	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		pacote = pDAO.buscarID(Integer.parseInt(request.getParameter("idPacote")));
		compra.setDataCompra(request.getParameter("data"));
		compra.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		cliente.setCpf(request.getParameter("cpf"));
		compra.setCliente(cliente);
		compra.setPacotes(pacote);
		cDAO.save(compra);
		response.sendRedirect("CompraLista");
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Compra> lista = new ArrayList<Compra>();
		lista = cDAO.getCompra();
		request.setAttribute("lista", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./crud/compraLista.jsp");
		rd.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCompra = Integer.parseInt(request.getParameter("idCompra"));
		compra = cDAO.buscarID(idCompra);
		request.setAttribute("idCompra", compra.getIdCompra());
		request.setAttribute("cpf", compra.cpf());
		request.setAttribute("data", compra.getDataCompra());
		request.setAttribute("idPacotes", compra.idPacote());
		request.setAttribute("quantidade", compra.getQuantidade());
		RequestDispatcher rd = request.getRequestDispatcher("./crud/compraUpdate.jsp");
		rd.forward(request, response);

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cliente.setCpf(request.getParameter("cpf"));
		compra.setCliente(cliente);
		compra.setDataCompra(request.getParameter("data"));
		compra.setIdCompra(Integer.parseInt(request.getParameter("idCompra")));
		pacote = pDAO.buscarID(Integer.parseInt(request.getParameter("idPacote")));
		compra.setPacotes(pacote);
		compra.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		cDAO.update(compra);
		response.sendRedirect("CompraLista");

	}
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		cDAO.removeById(Integer.parseInt(request.getParameter("idCompra")));
		response.sendRedirect("CompraLista");
	}

}
