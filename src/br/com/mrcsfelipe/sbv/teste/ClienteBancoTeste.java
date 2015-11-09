package br.com.mrcsfelipe.sbv.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.mrcsfelipe.sbv.dao.ClienteDao;
import br.com.mrcsfelipe.sbv.dao.ClienteJDBCDao;
import br.com.mrcsfelipe.sbv.dao.Dao;
import br.com.mrcsfelipe.sbv.model.Cliente;

public class ClienteBancoTeste extends Dao{
	
	private ClienteDao clienteDao = new ClienteJDBCDao();
	
	@Test
	public void testeConexaoDoPostgre(){
		try {
			open();
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Ignore
	public void inserirCliente(){
		
		try {
			Cliente cliente = 
					new Cliente(null, 
								"Marcos", 
								"1306", 
								"mfelipesp@gmail.com");
			
			Long id = clienteDao.salvarCliente(cliente);
			
			if(id == 0 ){
				System.out.println("Deu pau em algum lugar");
				return;
			}
			
			System.out.println("Id do cliente eh: " + id);
			
			cliente.setId(id);
			Cliente c = clienteDao.buscarClientePorId(id);
			
			assertEquals(cliente, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void trazendoTodosOsUsuarios(){
		List<Cliente> clientes;
		try {
			clientes = clienteDao.buscarTodosClientes();
			for(Cliente c : clientes){
				System.out.println(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
 	}
	
	
	
	
	
	
	
	
	
}
