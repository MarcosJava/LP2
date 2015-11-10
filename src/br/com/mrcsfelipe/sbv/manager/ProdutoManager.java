package br.com.mrcsfelipe.sbv.manager;

import br.com.mrcsfelipe.sbv.dao.ProdutoDao;
import br.com.mrcsfelipe.sbv.dao.ProdutoJDBCDao;
import br.com.mrcsfelipe.sbv.exceptions.ManagerException;
import br.com.mrcsfelipe.sbv.model.Produto;

public class ProdutoManager {
	
	private ProdutoDao produtoDao;
	
	public ProdutoManager() {
		produtoDao = new ProdutoJDBCDao();
	}
	
	public boolean hasDados(Produto p) {
		
		if(p.getNome() != null || 
				p.getNome().equals("")){
			throw new ManagerException("Valor não tem Nome");
			
		} else if(p.getMarca() != null || 
				p.getMarca().equals("")){
			throw new ManagerException("Valor não tem Marca");
		
		} else if(p.getModelo() != null || 
				p.getModelo().equals("")){
			throw new ManagerException("Não tem modelo");
		
		}else if(p.getDataFabricacao() != null ){
			throw new ManagerException("Não tem data de fabricação");
		
		} else if(p.getQuantidadeEstoque() != null || 
				p.getQuantidadeEstoque() > 0){
			throw new ManagerException("Quantidade do estoque acima de zero");
		
		}else if(p.getValor() != null){
			throw new ManagerException("Valor não pode ser nulo");
		}
		
		
		return true;
		
	}
	
	public long salvarProduto(Produto p ) throws Exception {
		
		if(hasDados(p)){
			return produtoDao.salvarProduto(p);
		} else {
			return 0;
		}
	}
	
	public Produto trazerProdutoPorId(long id) throws Exception {
		
		if(id > 0 ){
			throw new ManagerException("Não tem ID o Produto");
		}
		
		Produto p = this.produtoDao.getProdutoById(id);
		
		return p;
	}
	
	

}
