package br.com.mrcsfelipe.sbv.teste;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import br.com.mrcsfelipe.sbv.dao.ProdutoDao;
import br.com.mrcsfelipe.sbv.dao.ProdutoJDBCDao;
import br.com.mrcsfelipe.sbv.model.Cliente;
import br.com.mrcsfelipe.sbv.model.Produto;

public class ProdutoBancoTeste {

	
	Produto p = new Produto("Honda Civic",
			"Civic", "Honda", new Date(), 80500.00, 5);
	ProdutoDao produtoDao = new ProdutoJDBCDao();
	
	@Test
	public void salvarProduto(){
		try {
			long id = produtoDao.salvarProduto(p);
			System.out.println("id é :" + id);
			assertEquals(id, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Test
	public void trazendoProdutoID1(){
		try {
			Produto p = new Produto();
			p.setId(1L);
			
			Produto pRetorno = produtoDao.getProdutoById(1L);
			System.out.println(pRetorno);
			assertEquals(p, pRetorno);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	
	
}
