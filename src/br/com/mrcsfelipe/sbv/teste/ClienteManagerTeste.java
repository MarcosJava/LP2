package br.com.mrcsfelipe.sbv.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.mrcsfelipe.sbv.exceptions.ManagerException;
import br.com.mrcsfelipe.sbv.manager.ClienteManager;
import br.com.mrcsfelipe.sbv.model.Cliente;

public class ClienteManagerTeste {
	
	ClienteManager manager;
	
	
	
	@Before
	public void init(){
		manager = new ClienteManager();
		
	}
	
	@Ignore
	@Test
	public void salvarClientexxxx(){
		try {
			Cliente cliente = new Cliente(null, 
										  "Marcos", 
										  "233.345.987-09", 
										  "123", 
										  "markin");
			
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
			Cliente cliente = new Cliente(null, 
					  "", 
					  "233.345.987-09", 
					  "123", 
					  "markin");
			
			Long id = 0L;
			
			try{
				id = manager.salvarCliente(cliente);
			}catch(ManagerException e){
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
		
		Cliente cliente = new Cliente(0L, 
				  "Marcos", 
				  "233.345.987-09", 
				  "123", 
				  "markin");
		
		try {
			long id = manager.deletarCliente(cliente);
			
			System.out.println("ID QUE FOI DELETADO : " + id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	@Test//(expected = ClienteManagerException.class)
	public void excluindoClienteIdInexistente(){
		
		Cliente cliente = new Cliente(9999999999L, 
				  "Marcos", 
				  "233.345.987-09", 
				  "123", 
				  "markin");
		
		String saidaExperada = "ID inexistente";
		String saidaScript = "";
		
		try {
			manager.deletarCliente(cliente);
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
	
	
	
	@Test
	public void editandoCliente(){
		
		long idForEdit = 4;
		try {
			
			Cliente c = new Cliente(idForEdit, "Joao", "999.999.999-99", "1234", "John");
			Cliente cBefore = manager.editarCliente(c);
			
			System.out.println("EDITOU O CLIENTE  = " + cBefore);
			
			assertEquals(c, cBefore);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
