package br.com.mrcsfelipe.sbv.manager;

import java.util.List;

import br.com.mrcsfelipe.sbv.dao.ClienteDao;
import br.com.mrcsfelipe.sbv.dao.ClienteJDBCDao;
import br.com.mrcsfelipe.sbv.exceptions.ClienteManagerException;
import br.com.mrcsfelipe.sbv.model.Cliente;

public class ClienteManager {
	
	private ClienteDao clienteDao;
	
	public ClienteManager() {
		clienteDao = new ClienteJDBCDao();
	}
	
	public boolean hasData(Cliente c){
		
		if(c.getNome() == null || c.getNome().isEmpty()){
			throw new ClienteManagerException("Preencher o nome !");
			
			
		} else if (c.getCpf() == null || c.getCpf().isEmpty()){
			throw new ClienteManagerException("Preencher o cpf !");
			
		} else if (c.getEmail() == null || c.getEmail().isEmpty()){
			throw new ClienteManagerException("Preencher o email !");
			
		} else {
			return true;
		}
		
	}
	
	
	public List<Cliente> getAllClientes() throws Exception{
		return clienteDao.buscarTodosClientes();
	}
	
	public long salvarCliente(Cliente c) throws Exception{
		
		if(hasData(c))
			return clienteDao.salvarCliente(c);
		
		return 0;
	}
	
	public Cliente getClienteById(long id) throws Exception{
		return clienteDao.buscarClientePorId(id);
	}
	
	public void deletarCliente(Cliente c) throws Exception{
		if(c.getId() != null || c.getId() != 0){
			clienteDao.deletarCliente(c);
		} else {
			throw new ClienteManagerException("Ocorreu um erro ao deletar. ID incorreto");
		}
	}

}
