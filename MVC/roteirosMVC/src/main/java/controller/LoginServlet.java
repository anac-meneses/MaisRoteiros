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

import modelo.Login;
import modelo.LoginDAO;

@WebServlet(urlPatterns = { "/LoginCadastro", "/LoginLista", "/LoginUpdate", "/LoginEdit", "/LoginDel" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginDAO log = new LoginDAO();
	Login l = new Login();

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/LoginCadastro":
			create(request, response);
			break;
		case "/LoginLista":
			read(request, response);
			break;
		case "/LoginUpdate":
			update(request, response);
			break;
		case "/LoginEdit":
			edit(request, response);
			break;
		case "/LoginDel":
			delet(request, response);
			break;
		default:
			response.sendRedirect("Home.html");
			break;
		}

	}

	protected void create(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		l.setTipoLogin(request.getParameter("permissao"));
		log.save(l);
		response.sendRedirect("LoginLista");

	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Login> lista = new ArrayList<Login>();
		lista = log.getLogin();

		request.setAttribute("lista", lista);
		RequestDispatcher rd = request.getRequestDispatcher("./crud/loginLista.jsp");
		rd.forward(request, response);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idlogin = Integer.parseInt(request.getParameter("id"));
		l = log.buscarID(idlogin);
		request.setAttribute("idLogin", l.getIdLogin());
		request.setAttribute("permissao", l.getTipoLogin());
		RequestDispatcher rd = request.getRequestDispatcher("./crud/loginUpdate.jsp");
		rd.forward(request, response);
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		l.setIdLogin(Integer.parseInt(request.getParameter("idLogin")));
		l.setTipoLogin(request.getParameter("permissao"));
		log.update(l);
		response.sendRedirect("LoginLista");
	}

	protected void delet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		log.removeById(Integer.parseInt(request.getParameter("id")));
		response.sendRedirect("LoginLista");
	}
}
