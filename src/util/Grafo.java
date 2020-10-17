
package util;

import java.util.ArrayList;
import java.util.Objects;



public class Grafo <V,A,P>{
    
    ArrayList<Vertice> vertices;
    ArrayList<Aresta> arestas;

    public Grafo() {
        vertices = new ArrayList();
        arestas = new ArrayList();
    }
    
    //Metodo para adicionar arrestas na lista de arestas
    void adicionarAresta(V origem, V destino, P peso) throws NotVerticeException{
        int indexOrigem = vertices.indexOf(origem);
        int indexDestino = vertices.indexOf(destino);
        
        if(indexOrigem < 0 || indexDestino < 0)
            throw new NotVerticeException();
        
        Aresta a = new Aresta(vertices.get(indexOrigem), vertices.get(indexDestino), peso);
        
        arestas.add(a);         
    }

    //Metodo que ira retornar uma lista de adjacencias apartir de uma origem
    ArrayList<V> adjacentesDe(V origem) throws NotVerticeException{
        int indexOrigem = vertices.indexOf(origem);
        
        if(indexOrigem < 0)
            throw new NotVerticeException();
        
        ArrayList ret = new ArrayList();
        
        for(Aresta a : arestas){
            if(a.origem.equals(origem)){
                if(!ret.contains(a))
                    ret.add(a);
            }
        }
        return ret.isEmpty() ? null : ret;
    }

    ArrayList<A> arestasEntre(V origem, V destino){
        
        return null;
    }

    //Metodo que verifica se extiste uma aresta entre os vertices
    boolean existeAresta(V origem, V destino) throws NotVerticeException{ 
        int indexOrigem = vertices.indexOf(origem);
        int indexDestino = vertices.indexOf(destino);
        
        if(indexOrigem < 0 || indexDestino < 0)
            throw new NotVerticeException();
        
        for(Aresta a : arestas){
            if( a.origem.equals(origem)&& a.destino.equals(destino) ){
                return true;
            }
        }
        return false;
    }

    int grauDoVertice(V vertice) throws NotVerticeException{
 
        if(!vertices.contains(vertice))
            throw new NotVerticeException();
        
        int num = 0;
        
        for(Aresta a: arestas){
            if(a.destino.equals(vertice)){
                num++;
            }
        }
        return num;
    }

    int numeroDeArestas(){
        return arestas.size();
    }

    int numeroDeVertices(){
        return vertices.size();
    }
               
    void setarPeso(Vertice origem, Vertice destino, P peso) throws NotVerticeException{
        int indexOrigem = vertices.indexOf(origem);
        int indexDestino = vertices.indexOf(destino);
        
        if(indexOrigem < 0 || indexDestino < 0)
            throw new NotVerticeException();
        
        for(Aresta a : arestas){
            if(a.origem.equals(origem) && a.destino.equals(destino)){
                a.setPeso(peso);
            }
        }
    }

    ArrayList<V> vertices(){
        return (ArrayList<V>) vertices;
    }
    
    private class Vertice {
        
        private int id;
        private V vertice;
        
        public Vertice(int id, V vertice){
            this.id = id;
            this.vertice = vertice;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public V getVertice() {
            return vertice;
        }

        public void setVertice(V vertice) {
            this.vertice = vertice;
        }

   
        @Override
        public boolean equals(Object obj) {
            if(obj.getClass() == this.getClass()){
                return this.vertice.equals(((Vertice) obj).vertice);
            }
            if(obj.getClass() == this.vertice.getClass()){
                return obj.equals(this.vertice);
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 89 * hash + Objects.hashCode(this.vertice);
            return hash;
        }

    }
    
    private class Aresta {
        
        private Vertice origem;
        private Vertice destino;
        private P peso;

        public Aresta(Vertice origem, Vertice destino, P peso) {
            this.origem = origem;
            this.destino = destino;
            this.peso = peso;
        }

        public Vertice getOrigem() {
            return origem;
        }

        public void setOrigem(Vertice origem) {
            this.origem = origem;
        }

        public Vertice getDestino() {
            return destino;
        }

        public void setDestino(Vertice destino) {
            this.destino = destino;
        }

        public P getPeso() {
            return peso;
        }

        public void setPeso(P peso) {
            this.peso = peso;
        }
        
       
    }
    
    
}
