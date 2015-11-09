package br.com.mrcsfelipe.sbv.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.mrcsfelipe.sbv.manager.ClienteManager;
import br.com.mrcsfelipe.sbv.model.Cliente;

/**
 * Servlet implementation class ClienteListar
 */
@WebServlet("/pages/clienteListar")
public class ClienteListarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ClienteListarController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ClienteManager managerCliente = new ClienteManager();
			List<Cliente> clientes = managerCliente.getAllClientes();
			request.setAttribute("listClientes", clientes);
			request.getRequestDispatcher("/pages/listaClientes.jsp")
				   .forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("error500.jsp")
			   .forward(request, response);
		}
		
		
	}

}
