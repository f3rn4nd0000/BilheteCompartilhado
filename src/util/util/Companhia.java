package util;
import java.util.*;

public class Companhia {
    
	private int quantidade_passagens; //quantidade de passagens ofertadas
    private LinkedList<Cliente> lista_clientes;		//lista com todos os clientes que pretendem viajar por essa companhia
    private String nome_companhia;		
    
    
    public Companhia(String nome_companhia){
    	this.quantidade_passagens = quantidade_passagens;
    	this.lista_clientes = lista_clientes;
    	this.nome_companhia = nome_companhia;
    }

	public int getQuantidade_passagens() {
		return quantidade_passagens;
	}

	public void setQuantidade_passagens(int quantidade_passagens) {
		this.quantidade_passagens = quantidade_passagens;
	}

	public LinkedList<Cliente> getLista_clientes() {
		return lista_clientes;
	}

	public void setLista_clientes(LinkedList<Cliente> lista_clientes) {
		this.lista_clientes = lista_clientes;
	}

	public String getNome_companhia() {
		return nome_companhia;
	}

	public void setNome_companhia(String nome_companhia) {
		this.nome_companhia = nome_companhia;
	}
	
	/**
	 * 
	 * @param nome_cliente
	 * @return O Cliente cujo nome foi passado para parâmetro, caso não exista, não retorna nada!
	 */
	public Cliente getCliente(String nome_cliente) {
		
		for(int i = 0; i < this.lista_clientes.size(); i++)
			if(this.lista_clientes.get(i).getIdentificacao().equals(nome_cliente))
				return this.lista_clientes.get(i);
		
		return null;
	}
	

	
}
