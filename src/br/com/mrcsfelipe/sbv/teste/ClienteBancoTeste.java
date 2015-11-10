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
	
	@Test
	public void inserirCliente(){
		
		try {
			Cliente cliente = 
					new Cliente(null, "Marcos", "200.322.122-98", "123", "mark");
			
			Long id = clienteDao.salvarCliente(cliente);
			
			if(id == 0 ){
				System.out.println("Deu pau em algum lugar");
				return;
			}
			
			System.out.println("SALVOU O CLIENTE COM Id: " + id);
			
			cliente.setId(id);
			Cliente c = clienteDao.buscarClientePorId(id);
			
			assertEquals(cliente, c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void trazendoTodosOsUsuarios(){
		System.out.println("TODOS OS USUARIO");
		List<Cliente> clientes;
		try {
			clientes = clienteDao.buscarTodosClientes();
			for(Cliente c : clientes){
				System.out.println(c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
 	}
	
	@Test
	public void trazendoUsuarioPorID1(){
		System.out.println("USUARIO DO ID 1");
		Cliente cliente;
		try {
			cliente = clienteDao.buscarClientePorId(1L);
			System.out.println(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
 	}
	
	@Test
	public void deletandoCliente(){
		
		try {
			
			long idDeletar = 2L;
			
			Cliente cPreparado = new Cliente();
			cPreparado.setId(idDeletar);
			
			long id = clienteDao.deletarCliente(cPreparado);
			
			Cliente cEsperado = new Cliente();
			cEsperado.setId(id);
			
			System.out.println("DELETOU O CLIENTE = " + id);
			
			assertEquals(cPreparado, cEsperado);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
}
