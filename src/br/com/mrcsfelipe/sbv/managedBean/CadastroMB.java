package br.com.mrcsfelipe.sbv.managedBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.mrcsfelipe.sbv.manager.ClienteManager;
import br.com.mrcsfelipe.sbv.model.Cliente;


@ManagedBean
@ViewScoped
public class CadastroMB {

	private Cliente cliente;
	private ClienteManager clienteManager = new ClienteManager();
	
	@PostConstruct
	public void init(){
		cliente = new Cliente();
		
	}
	
	public CadastroMB() {
		// TODO Auto-generated constructor stub
	}
	
	public void inserir(Cliente cliente) throws Exception{
		System.out.println("Inserindo..");
		clienteManager.salvarCliente(cliente);
		cliente = new Cliente();
	}
	

	
	//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx GETTERs e SETTERs xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx//
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}
