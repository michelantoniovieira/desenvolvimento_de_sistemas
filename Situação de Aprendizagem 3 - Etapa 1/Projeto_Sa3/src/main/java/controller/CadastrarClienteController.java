package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CadastrarClienteDAO;
import model.CadastrarClienteDTO;
import model.ConexaoDAO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns =
{ "/main", "/create", "/select", "/update", "/read", "/delete" })
public class CadastrarClienteController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	ConexaoDAO dao = new ConexaoDAO();
	CadastrarClienteDTO dto = new CadastrarClienteDTO();
	CadastrarClienteDAO cadastrarClienteDao = new CadastrarClienteDAO();

	public CadastrarClienteController()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		dao.testeConexao();
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main"))
		{
			principal(request, response);
		} else if (action.equals("/create"))
		{
			novoCliente(request, response);
		} else if (action.equals("/select"))
		{
			selecionarCliente(request, response);
		} else if (action.equals("/read"))
		{
			listarClientes(request, response);
		} else if (action.equals("/update"))
		{
			editarCliente(request, response);
		} else if (action.equals("/delete"))
		{
			removerCliente(request, response);
		} else
		{
			response.sendRedirect("index.jsp");
		}
	}

	// pagina principal
	protected void principal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.sendRedirect("index.jsp");
	}

	// novo cliente
	protected void novoCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		// teste de recebimento dos dados do formulario
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("endereco"));
		System.out.println(request.getParameter("modalidade"));

		dto.setNome(request.getParameter("nome"));
		dto.setEndereco(request.getParameter("endereco"));
		dto.setModalidade(request.getParameter("modalidade"));

		// cadastrar no banco
		cadastrarClienteDao.inserirCliente(dto);

		// redirecionar menu principal
		response.sendRedirect("main");
	}

	// selecionar clientes
	protected void selecionarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// recebimento da matricula que sera editada
		String matricula = request.getParameter("matricula");
		// setar a variavel na dto
		dto.setMatricula(matricula);
		// executar o metodo alteraCliente
		cadastrarClienteDao.selecionarCliente(dto);
		// setar os atributos do formulario com o conteudo do dto
		request.setAttribute("matricula", dto.getMatricula());
		request.setAttribute("nome", dto.getNome());
		request.setAttribute("endereco", dto.getEndereco());
		request.setAttribute("modalidade", dto.getModalidade());
		// encaminhar ao frmAlterarCliente
		RequestDispatcher rd = request.getRequestDispatcher("frmAlterarCliente.jsp");
		rd.forward(request, response);
	}

	// editar clientes
	protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// recebimento da matricula que sera editada
		dto.setMatricula(request.getParameter("matricula"));
		dto.setNome(request.getParameter("nome"));
		dto.setEndereco(request.getParameter("endereco"));
		dto.setModalidade(request.getParameter("modalidade"));
		// executar o metodo editar cliente
		cadastrarClienteDao.editarCliente(dto);
		// redirecionar para o index.jsp
		response.sendRedirect("main");
	}

	// editar clientes
	protected void removerCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// recebimento da matricula que sera excluida
		String matricula = request.getParameter("matricula");
		// setar variavel do dto
		dto.setMatricula(matricula);
		// executar o metodo excluir cliente
		cadastrarClienteDao.deletarCliente(dto);
		// redirecionar para o index.jsp
		response.sendRedirect("main");
	}

	// listar clientes
	protected void listarClientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ArrayList<CadastrarClienteDTO> lista = cadastrarClienteDao.listarClientes();
		// encaminhar a lista ao documento
		request.setAttribute("cliente", lista);
		RequestDispatcher rd = request.getRequestDispatcher("frmListarCliente.jsp");
		rd.forward(request, response);
	}
}
