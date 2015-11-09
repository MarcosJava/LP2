package br.com.mrcsfelipe.sbv.dao;

import java.util.List;

import br.com.mrcsfelipe.sbv.model.Produto;

public class ProdutoJDBCDao extends Dao implements ProdutoDao{

	
	
	public ProdutoJDBCDao() {
		
	}

	@Override
	public long salvarProduto(Produto p) throws Exception {
long idObject = 0;
				
	
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
	
	

}
