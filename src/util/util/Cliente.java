package util;
import java.lang.*;

class Cliente extends Thread {

    //origemC e destinoC se referem ao local onde o cliente compra a passagem e qual seu destino FINAL!    
    String identificacao;
    String origemC;     
    String destinoC;

    public Cliente(){
        this.identificacao = identificacao;
        this.origemC = origemC;
        this.destinoC = destinoC;
    }

    public String getOrigemC(){
        return this.origemC;
    }

    public String getDestinoC(){
        return this.destinoC;
    }

    public String getIdentificacao(){
        return this.identificacao;
    }

    public void setDestinoC(String destino){
        this.destinoC = destino;
    }

    public void setOrigemC(String origem){
        this.origemC = origem;
    }

    public void setIdentificacao(String id){
        this.identificacao = id;
    }
}