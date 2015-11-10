package br.com.mrcsfelipe.sbv.dao;

import java.sql.Date;
import java.util.List;

import br.com.mrcsfelipe.sbv.model.Cliente;
import br.com.mrcsfelipe.sbv.model.Produto;

public class ProdutoJDBCDao extends Dao implements ProdutoDao{

	
	
	public ProdutoJDBCDao() {
		
	}

	@Override
	public long salvarProduto(Produto p) throws Exception {
		long idObject = 0;
		
		
		try {
			open();
			
			stmt = con.prepareStatement("INSERT INTO "
					+ "	produto(nome, data_fabricacao, marca, modelo, preco, qtd_estoque) "
					+ " values(?,?,?,?,?,?) returning id_produto");
			
			java.sql.Date date = new Date(p.getDataFabricacao().getTime());
			
			stmt.setString(1, p.getNome());
			stmt.setDate(2, date);
			stmt.setString(3, p.getMarca() );
			stmt.setString(4, p.getModelo());
			stmt.setDouble(5, p.getValor());
			stmt.setInt(6, p.getQuantidadeEstoque() );
			rs = stmt.executeQuery();
			if(rs.next()){
				idObject = rs.getLong("id_produto");
			}
			stmt.close();
			close();
			return idObject;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
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

	@Override
	public boolean editarProduto(Produto p) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluirProduto(Produto p) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Produto> listarProduto(Produto p) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto getProdutoById(Long id) throws Exception {
		open();
		try {
			stmt = con.prepareStatement("SELECT * FROM produto WHERE id_produto=?");
			stmt.setLong(1, id);
			rs = stmt.executeQuery();
			
			Produto p = new Produto();
			while (rs.next()) {
				p.setId(rs.getLong("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setMarca(rs.getString("marca"));
				p.setModelo(rs.getString("modelo"));
				p.setQuantidadeEstoque(rs.getInt("qtd_estoque"));
				p.setValor(rs.getDouble("preco"));
				p.setDataFabricacao(new Date(rs.getDate("data_fabricacao").getTime()));
			}
			stmt.close();
			close();
			return p;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	
	

}
