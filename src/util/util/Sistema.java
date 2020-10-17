package util;
import java.util.*;
/**
 * Esta classe será a responsável por gerenciar a execução de todas as classes juntas
 * simulando o comportamento da aplicação de compra de passagens!
 */
public class Sistema {
    
    private Servidor server = new Servidor();
    private LinkedList clientes = new LinkedList();

    public static void main(String[] args) {
        System.out.println("Hello World!");    
    }
}
