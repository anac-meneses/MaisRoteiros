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

@WebServlet(urlPatterns = { "/DestinoCadastro", "/DestinoUpdate", "/DestinoLista", "/DestinoDel", "/DestinoEdit" })
public class DestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DestinosDAO desDAO = new DestinosDAO();
	Destino destino = new Destino();

	public DestinoServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/DestinoLista":
			read(request, response);
			break;
		case "/DestinoCadastro":
			create(request, response);
			break;
		case "/DestinoUpdate":
			update(request, response);
			break;
		case "/DestinoEdit":
			edit(request, response);
			break;
		case "/DestinoDel":
			delet(request, response);
			break;
		default:
			response.sendRedirect("Home.html");
			break;
		}
	}
		protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			List<Destino> lista = new ArrayList<Destino>();
			lista = desDAO.getDestino();				
			request.setAttribute("lista", lista);
			RequestDispatcher rd = request.getRequestDispatcher("./crud/DestinosLista.jsp");
			rd.forward(request, response);
		}
		
		protected void create(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			destino.setCidade(request.getParameter("cidade"));
			destino.setPais(request.getParameter("pais"));
			desDAO.save(destino);
			response.sendRedirect("DestinoLista");

		}
		protected void update(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			destino = desDAO.buscarID(id);
			request.setAttribute("idDestino", destino.getIdDestino());
			request.setAttribute("cidade", destino.getCidade());
			request.setAttribute("pais", destino.getPais());
			RequestDispatcher rd = request.getRequestDispatcher("./crud/destinoUpdate.jsp");
			rd.forward(request, response);
		}
		protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int idDestino = Integer.parseInt(request.getParameter("idDestino"));
			destino.setIdDestino(idDestino);
			destino.setCidade(request.getParameter("cidade"));
			destino.setPais(request.getParameter("pais"));
			desDAO.update(destino);
			response.sendRedirect("DestinoLista");
			}
		protected void delet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException { 
			desDAO.removeById(Integer.parseInt(request.getParameter("id")));
			response.sendRedirect("DestinoLista");
		}
	}