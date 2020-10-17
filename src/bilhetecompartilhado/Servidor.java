import java.util.LinkedList;
import java.util.*;

/**
 * Esta classe irá armazenar todos os dados relativos as rotas!
 * Além disso irá gerenciar a compra e venda de passagens.
 */
public class Servidor {
    private int quantidade_cidades = 10; //serão 20 rotas diferentes geradas a partir dessa quantia.
    private int quantidade_rotas = 20;
    private LinkedList clientesA = new LinkedList();
    private LinkedList lista = new LinkedList(); //contém todos os passageiros????
    private String[] rotasPossiveis = new String[20]; //contém todas as possíveis rotas que podem ser formadas a partir da combinação das 5 cidades (a,b,c,d,e) ex: ab, bc, ac, cd,...
    private Cliente c = new Cliente();
    //20 rotas possíveis : ab ac ad ae ba bc bd be ca cb cd ce da db dc de ea eb ec ed 
    
    public Servidor(){
        this.quantidade_cidades = quantidade_cidades;
        this.quantidade_rotas = quantidade_rotas;
        this.lista = lista;
        this.rotasPossiveis = rotasPossiveis;
    }    

    //confirmar se a viagem pode ser feita
    public void getViagem(String x, String y){
        
    }

}
