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

import modelo.Destino;
import modelo.DestinosDAO;
import modelo.Pacotes;
import modelo.PacotesDAO;

@WebServlet(urlPatterns = { "/PacoteCadastro", "/PacoteLista", "/PacoteUpdate", "/PacoteEdit", "/PacoteDel" })

public class PacotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Pacotes pacote = new Pacotes();
	PacotesDAO pDAO = new PacotesDAO();	
	Destino destino = new Destino();
	DestinosDAO dDAO = new DestinosDAO();
	public PacotesServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/PacoteCadastro":
			create(request, response);
			break;
		case "/PacoteLista":
			read(request, response);
			break;
		case "/PacoteUpdate":
			update(request, response);
			break;
		case "/PacoteEdit":
			edit(request, response);
			break;
		case "/PacoteDel":
			delet(request, response);
			break;
		default:
			response.sendRedirect("Home.html");
			break;
		}
	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		pacote.setHotel(request.getParameter("hotel"));
		pacote.setTranslado(request.getParameter("translado"));
		pacote.setQtNoites(request.getParameter("noites"));
		pacote.setPreco(Integer.parseInt(request.getParameter("preco")));
		destino.setIdDestino(Integer.parseInt(request.getParameter("idDestino")));
		pacote.setDestino(destino);
		pDAO.save(pacote);
		response.sendRedirect("PacoteLista");

	}
	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Pacotes> lista = new ArrayList<Pacotes>();
		lista = pDAO.getPacotes();				
		request.setAttribute("lista", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./crud/pacoteLista.jsp");
		rd.forward(request, response);
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		pacote = pDAO.buscarID(id);
		request.setAttribute("hotel", pacote.getHotel());
		request.setAttribute("noites", pacote.getQtNoites());
		request.setAttribute("translado", pacote.getTranslado());
		request.setAttribute("preco", pacote.getPreco());
		request.setAttribute("idPacote", pacote.getIdPacote());
		request.setAttribute("idDestino", pacote.getDestino().getIdDestino());
		RequestDispatcher rd = request.getRequestDispatcher("./crud/pacotesUpdate.jsp");
		rd.forward(request, response);
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		pacote.setIdPacote(Integer.parseInt(request.getParameter("idPacote")));
		pacote.setPreco(Integer.parseInt(request.getParameter("preco")));
		pacote.setQtNoites(request.getParameter("noites"));
		pacote.setTranslado(request.getParameter("translado"));
		pacote.setHotel(request.getParameter("hotel"));
		destino.setIdDestino(Integer.parseInt(request.getParameter("idDestino")));
		pacote.setDestino(destino);
		pDAO.update(pacote);
	
		response.sendRedirect("PacoteLista");
		}
	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		pDAO.removeById(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect("PacoteLista");
	}
}
