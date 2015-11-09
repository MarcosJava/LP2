package br.com.mrcsfelipe.sbv.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.mrcsfelipe.sbv.exceptions.ClienteManagerException;
import br.com.mrcsfelipe.sbv.manager.ClienteManager;
import br.com.mrcsfelipe.sbv.model.Cliente;

public class ClienteManagerTeste {
	
	ClienteManager manager;
	
	
	
	@Before
	public void init(){
		manager = new ClienteManager();
		
	}
	

	@Test
	public void salvarClientexxxx(){
		try {
			Cliente cliente = 
					new Cliente(null, 
								"Marcos", 
								"1306", 
								"mfelipesp@gmail.com");
			
			Long id = manager.salvarCliente(cliente);
			
			if(id == 0 ){
				System.out.println("Deu pau em algum lugar");
				return;
			}
			
			System.out.println("Id do cliente eh: " + id);
			
			cliente.setId(id);
			Cliente c = manager.getClienteById(id);
			
			assertEquals(cliente, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void salvarClienteNomeVazio(){
		
		String saida = "";
		
		try {
			Cliente cliente = 
					new Cliente(null, 
								"", 
								"1306", 
								"mfelipesp@gmail.com");
			
			Long id = 0L;
			
			try{
				id = manager.salvarCliente(cliente);
			}catch(ClienteManagerException e){
				System.out.println(e);
				//e.printStackTrace();
				saida = e.getMessage();
			}
		
			
			System.out.println("Id do cliente eh: " + id);
			
			cliente.setId(id);
			Cliente c = manager.getClienteById(id);
			
			assertEquals(saida, "Preencher o nome !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test//(expected = ClienteManagerException.class)
	public void excluindoClienteIdZero(){
		
		Cliente c = new Cliente(0L, 
								"maria", 
								"123.332.123-02", 
								"mariazinha@gmail.com");
		
		try {
			manager.deletarCliente(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		
		
	}
	
	
	@Test//(expected = ClienteManagerException.class)
	public void excluindoClienteIdInexistente(){
		
		Cliente c = new Cliente(99999999L, 
								"maria", 
								"123.332.123-02", 
								"mariazinha@gmail.com");
		
		String saidaExperada = "ID inexistente";
		String saidaScript = "";
		
		try {
			manager.deletarCliente(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			saidaScript = e.getMessage();
		}
		
		assertEquals(saidaExperada, saidaScript);
		
	}
	
	@Test
	public void listandoClientes(){
		try {
			List<Cliente> clientes = manager.getAllClientes();
			for(Cliente c : clientes){
				System.out.println(c.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	// TDD - Test Drive Development 
	
	
	

}
