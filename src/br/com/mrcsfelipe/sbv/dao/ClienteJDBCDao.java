package br.com.mrcsfelipe.sbv.dao;

import java.sql.SQLException;
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
					+ "	cliente(nome, cpf, login, senha) "
					+ " values(?,?,?,?) returning id_cliente");
			
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCpf()); 
			stmt.setString(3, c.getLogin());
			stmt.setString(4, c.getSenha());
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
	
	public long deletarCliente(Cliente c) throws Exception {
		open();

		stmt = con.prepareStatement("DELETE FROM cliente WHERE id_cliente=?");
		stmt.setLong(1, c.getId());
		int deleteCount = stmt.executeUpdate();
		if(deleteCount == 0){
			throw new ClienteManagerException("ID inexistente");
		}
		stmt.close();

		close();
		return deleteCount;
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
				cliente.setNome(rs.getString("nome"));
				cliente.setLogin(rs.getString("login"));
				cliente.setSenha(rs.getString("senha"));
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
									rs.getString("senha"), 
									rs.getString("login"));

			listCliente.add(c);

		}

		stmt.close();

		close();
		return listCliente;
	}

	@Override
	public Cliente editarCliente(Cliente c) throws Exception {
		
		try {
			open();
			
			stmt = con.prepareStatement("UPDATE cliente SET "
					+ "	nome = ?, cpf = ?, login = ?, senha = ? "
					+ " WHERE id_cliente = ?");
			
			
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCpf()); 
			stmt.setString(3, c.getLogin());
			stmt.setString(4, c.getSenha());
			stmt.setLong(5,  c.getId());
			stmt.execute();
			
			stmt.close();
			close();
			return c;
			
		} catch (SQLException e) {
			throw new ClienteManagerException(e.getMessage());
			
		}finally{
			close();
		}
	}
	
	
	

}
