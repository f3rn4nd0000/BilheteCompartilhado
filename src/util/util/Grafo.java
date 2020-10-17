package util;

import java.util.ArrayList;
import java.util.Objects;



public class Grafo <V,A,P>{
    
    ArrayList<Vertice> vertices;
    ArrayList<Aresta> arestas;

    public Grafo() {
        vertices = new ArrayList(); //contem todos os vertices do grafo!
        arestas = new ArrayList();	//contem todas as arestas do grafo!
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

    /**
     * Algoritmo para buscar todos os caminhos possíveis no grafo a partir de um ponto "origem" passado como parâmetro!
     * https://en.wikipedia.org/wiki/Depth-first_search
     * @param G
     * @param origem
     * @return
     * @throws NotVerticeException 
     */
    public ArrayList<A> buscaEmProfundidade(Grafo G, Vertice origem) throws NotVerticeException {

    	origem.setEncontrado();
    	
    	for(Vertice w : vertices) {
    		if(G.adjacentesDe(origem).equals(w)) {
    			
    		}
    	}
    	
    	return null;
    }
    
    ArrayList<A> arestasEntre(V origem, V destino){
        
        return null;
    }

    //Metodo que verifica se existe uma aresta entre os vertices
    /**
     * 
     * @param origem Vértice de origem!
     * @param destino Vértice de destino!
     * @return
     * @throws NotVerticeException
     */
    boolean existeAresta(V origem, V destino) throws NotVerticeException{ 
        int indexOrigem = vertices.indexOf(origem);
        int indexDestino = vertices.indexOf(destino);
        
        if(indexOrigem < 0 || indexDestino < 0)
            throw new NotVerticeException();
        
        for(Aresta a : arestas){
        
            if( a.getOrigem().equals(origem)&& a.getDestino().equals(destino) ){ //se a aresta possui mesmo destino e origem que 
                return true;
            }
        }
        return false;
    }
    
    /**
     * Calcula o grau do vértice!
     * @param vertice
     * @return	quantidade de vértices adjacentes ao vértice passado como parâmetro
     * @throws NotVerticeException
     */
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
        private boolean foiEncontrado;
        private ArrayList<Aresta> arestasV; //contem todas as arestas do grafo ligadas a esse vertice.
        
        
		public Vertice(int id, V vertice){
            this.id = id;
            this.vertice = vertice;
            this.foiEncontrado = false;
        }
        
        //lista todos os vertices que são vizinhos.
        public ArrayList getVizinhos() {
        	ArrayList<Vertice> arestasV = new ArrayList<Vertice>(); //nessa lista serão inseridos os vertices vizinhos
        	for(int index = 0 ; index < arestas.size() ; index++)
        	if(arestas.get(index).getDestino().equals(this)) //se em alguma das arestas da classe grafo for encontrado esse vertice entao pega o outro vertice ligado a essa aresta e adiciona!
        		arestasV.get(index).setVertice(vertices.get(index)); 
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
        
        public ArrayList<Aresta> getArestas() {
        	return arestas;
        }
        
        public void setArestas(ArrayList<Aresta> arestas) {
        	this.arestas = arestas;
        }
        
        public void setEncontrado() {
        	this.foiEncontrado = true;
        }
        
        //retorna true se o algoritmo de verificação já passou por esse vértice!
        public boolean getEncontrado() {
        	return foiEncontrado;
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
        
     /*   public boolean verticeEncontrado() {
        	this.setEncontrado();
        	return w.getEncontrado();
        }*/
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
