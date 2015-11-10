package br.com.mrcsfelipe.sbv.dao;

import java.util.List;

import br.com.mrcsfelipe.sbv.model.Cliente;

public interface ClienteDao{
	
	public long salvarCliente(Cliente c)throws Exception;
	public long deletarCliente(Cliente c) throws Exception;
	public Cliente editarCliente(Cliente c)throws Exception;
	public Cliente buscarClientePorId(Long id) throws Exception;
	public List<Cliente> buscarTodosClientes() throws Exception;

}
