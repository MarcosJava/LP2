package br.com.mrcsfelipe.sbv.manager;

import java.util.List;

import br.com.mrcsfelipe.sbv.dao.ClienteDao;
import br.com.mrcsfelipe.sbv.dao.ClienteJDBCDao;
import br.com.mrcsfelipe.sbv.exceptions.ManagerException;
import br.com.mrcsfelipe.sbv.model.Cliente;

public class ClienteManager {
	
	private ClienteDao clienteDao;
	
	public ClienteManager() {
		clienteDao = new ClienteJDBCDao();
	}
	
	public boolean hasData(Cliente c){
		
		if(c.getNome() == null || c.getNome().isEmpty()){
			throw new ManagerException("Preencher o nome !");
			
			
		} else if (c.getCpf() == null || c.getCpf().isEmpty()){
			throw new ManagerException("Preencher o cpf !");
			
		} else if (c.getLogin() == null || c.getLogin().isEmpty()){
			throw new ManagerException("Preencher o login !");
			
		} else if (c.getSenha() == null || c.getSenha().isEmpty()){
			throw new ManagerException("Preencher a senha !");
			
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
	
	public Cliente editarCliente(Cliente c) throws Exception{
		
		if(hasId(c)){
			return clienteDao.editarCliente(c);
		}
		throw new ManagerException("Ocorreu um erro ao editar Cliente");
		
	}
	
	private boolean hasId(Cliente c) {
		if(c.getId() != null
				|| c.getId() > 0 ){
			
			return true;
		}
		return false;
	}

	public Cliente getClienteById(long id) throws Exception{
		if(id > 0)
			return clienteDao.buscarClientePorId(id);
		throw new ManagerException("Informe um ID");
	}
	
	public long deletarCliente(Cliente c) throws Exception{
		long retorno = 0;
		
		if(c.getId() != null || c.getId() > 0){
			retorno = clienteDao.deletarCliente(c);
		} else {
			throw new ManagerException("Ocorreu um erro ao deletar. ID incorreto");
		}
		return retorno;
	}

}
