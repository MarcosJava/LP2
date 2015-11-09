package br.com.mrcsfelipe.sbv.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.mrcsfelipe.sbv.exceptions.ClienteManagerException;
import br.com.mrcsfelipe.sbv.model.Cliente;


public class ClienteJDBCDao extends Dao implements ClienteDao {
	
	
	public long salvarCliente(Cliente c) throws Exception{
		
		long idObject = 0;
		
		
		try {
			open();
			
			stmt = con.prepareStatement("INSERT INTO "
					+ "	cliente(nome, email, cpf) "
					+ " values(?,?,?) returning id_cliente");
			
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getEmail());
			stmt.setString(3, c.getCpf()); 
			rs = stmt.executeQuery();
			if(rs.next()){
				idObject = rs.getLong("id_cliente");
			}
			stmt.close();
			close();
			return idObject;
			
		} catch (Exception e) {
			try {
				close();
				return 0;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return 0;
	}
	
	public void deletarCliente(Cliente c) throws Exception {
		open();

		stmt = con.prepareStatement("DELETE FROM cliente WHERE id_cliente=?");
		stmt.setLong(1, c.getId());
		int deleteCount = stmt.executeUpdate();
		if(deleteCount == 0){
			throw new ClienteManagerException("ID inexistente");
		}
		stmt.close();

		close();
	}

	@Override
	public Cliente buscarClientePorId(Long id) throws Exception {	
		
		open();
		try {
			stmt = con.prepareStatement("SELECT * FROM cliente WHERE id_cliente=?");
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			
			Cliente cliente = new Cliente();
			while (rs.next()) {
				cliente.setId(rs.getLong("id_cliente"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setNome(rs.getString("nome"));
			}
			stmt.close();
			close();
			return cliente;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}

	@Override
	public List<Cliente> buscarTodosClientes() throws Exception {
		open();
		stmt = con.prepareStatement("SELECT * FROM cliente");
		rs = stmt.executeQuery();

		List<Cliente> listCliente = new ArrayList<Cliente>();
		
		while (rs.next()) {

			Cliente c = new Cliente(rs.getLong("id_cliente"), 
									rs.getString("nome"), 
									rs.getString("cpf"), 
									rs.getString("email"));

			listCliente.add(c);

		}

		stmt.close();

		close();
		return listCliente;
	}
	
	
	

}
