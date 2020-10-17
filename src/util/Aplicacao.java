import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;

public class Aplicacao {

    private Servidor server = new Servidor();
    private LinkedList lista_de_rotas = new LinkedList();
    private LinkedList lista_de_clientes = new LinkedList();

    //metodo que atualiza a compra de passagem por parte do cliente c!
    public void compraPassagem(Cliente c){
        String origem = c.getOrigemC();    
        System.out.println("Digite qual o seu local de destino:\n");
        Scanner ler = new Scanner(System.in);
        String checaDestino = ler.toString();
        if(server.getViagem(c.getOrigemC(),c.getDestinoC())){//verifica se as passagens do tipo origemC -> DestinoC existem)
        c.setDestinoC(checaDestino);   
        System.out.println("Passagem confirmada com sucesso!");
        }
        else {
            System.out.println("Precisamos remanejar seu voo!\nAqui estão as opções de conexão!");
            
        }
    }
}
