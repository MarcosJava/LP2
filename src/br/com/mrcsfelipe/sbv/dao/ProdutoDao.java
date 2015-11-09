package br.com.mrcsfelipe.sbv.dao;

import java.util.List;

import br.com.mrcsfelipe.sbv.model.Produto;

public interface ProdutoDao {
	
	public long salvarProduto(Produto p) throws Exception;
	public boolean editarProduto(Produto p) throws Exception;
	public boolean excluirProduto(Produto p) throws Exception;
	public List<Produto> listarProduto(Produto p) throws Exception;

}
