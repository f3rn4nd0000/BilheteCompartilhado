package util;
/**
 * Pode ser substituída pela classe aresta
 * @author ffern
 *
 */
public class Rota {
    
    String origem;
    String destino;

    public Rota(String origem, String destino){
        this.origem = origem;
        this.destino = destino;
    }

    public void setOrigem(){
        this.origem = origem;
    }

    public String getOrigem(String origem){
        return this.origem;
    }

    public void setDestino(){
        this.destino = destino;
    }

    public String getDestino(String destino) {
        return this.destino;
    }
    
    
}
