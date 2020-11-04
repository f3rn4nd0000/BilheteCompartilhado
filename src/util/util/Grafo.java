package util;

import Exceptions.NotVerticeException;
import Exceptions.NotPathException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import model.Aeroporto;


public class Grafo <V>{
    
    private final ArrayList<V> vertices;
    private final ArrayList<Aresta<V>> arestas;
    private final HashMap<V, ArrayList<Aresta<V>>> bucketArestas;

    public Grafo() {
<<<<<<< HEAD:src/util/util/Grafo.java
        vertices = new ArrayList(); //contem todos os vertices do grafo!
        arestas = new ArrayList();	//contem todas as arestas do grafo!
=======
        vertices = new ArrayList();
        arestas = new ArrayList();
        bucketArestas = new HashMap();
    }
    
    public void addVertice(V vertice) throws NotVerticeException{
        if(vertice == null)
            throw new NotVerticeException();
        if(vertices.contains(vertice))
            return;
        vertices.add(vertice);
        bucketArestas.put(vertice, new ArrayList());
    }
    
    public boolean containsVertice(V vertice){
        return vertices.contains(vertice);
    }
    
    public ArrayList<V> vertices(){
        ArrayList<V> ret = new ArrayList();
        vertices.forEach((v) -> {
            ret.add(v);
        });
        return ret.isEmpty()?null:ret;
>>>>>>> ebffaf5d601ececc83ddd6c5871494ba41fca061:src/util/Grafo.java
    }
    
    //Metodo para adicionar arrestas na lista de arestas
    public void addAresta(Aresta<V> aresta) throws NotVerticeException{
        V origem = aresta.getOrigem();
        V destino = aresta.getDestino();
        int indexOrigem = vertices.indexOf(origem);
        int indexDestino = vertices.indexOf(destino);
<<<<<<< HEAD:src/util/util/Grafo.java
 
=======
>>>>>>> ebffaf5d601ececc83ddd6c5871494ba41fca061:src/util/Grafo.java
        if(indexOrigem < 0 || indexDestino < 0)
            throw new NotVerticeException();
        arestas.add(aresta);
        bucketArestas.get(origem).add(aresta);
    }    
    
    //Metodo que irÃ¡ retornar uma lista de adjacencias apartir de uma origem
    public ArrayList<V> adjacentesDe(V origem) throws NotVerticeException{
        int indexOrigem = vertices.indexOf(origem);
        if(indexOrigem < 0)
            throw new NotVerticeException();
        ArrayList<V> ret = new ArrayList();
        for(Aresta<V> a : bucketArestas.get(origem)){
            ret.add(a.getDestino());
        }
        return ret.isEmpty() ? null : ret;
    }

<<<<<<< HEAD:src/util/util/Grafo.java
    /**
     * Algoritmo para buscar todos os caminhos possíveis no grafo a partir de um ponto "origem" passado como parâmetro!
     * https://en.wikipedia.org/wiki/Depth-first_search
     * @param G
     * @param origem
     * @return
     * @throws NotVerticeException 
     */
    
    public void buscaEmProfundidade(Grafo G, Vertice origem) throws NotVerticeException {
    	
    	origem.setEncontrado();
    	
    	for(Vertice w : vertices) {
    		if(G.adjacentesDe(origem).equals(w)) {
    			if(!w.getEncontrado())
    				buscaEmProfundidade(G,w);
    		}
    	}
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
=======
    public ArrayList<Aresta<V>> arestasEntre(V origem, V destino) throws NotVerticeException{
        ArrayList<Aresta<V>> ret = new ArrayList();
        int indexOrigem = vertices.indexOf(origem);
        int indexDestino = vertices.indexOf(destino);
        if(indexOrigem<0 || indexDestino<0)
            throw new NotVerticeException();
        bucketArestas.get(origem).forEach((a)->{
            if(a.getDestino().equals(destino) )
                ret.add(a);
        });
        return ret.isEmpty()?null:ret;
    }

    //MÃ©todo que verifica se extiste uma aresta entre os vertices
    public boolean existeAresta(V origem, V destino) throws NotVerticeException{ 
>>>>>>> ebffaf5d601ececc83ddd6c5871494ba41fca061:src/util/Grafo.java
        int indexOrigem = vertices.indexOf(origem);
        int indexDestino = vertices.indexOf(destino);
        if(indexOrigem < 0 || indexDestino < 0)
            throw new NotVerticeException();
<<<<<<< HEAD:src/util/util/Grafo.java
        
        for(Aresta a : arestas){
        
            if( a.getOrigem().equals(origem)&& a.getDestino().equals(destino) ){ //se a aresta possui mesmo destino e origem que 
=======
        for(Aresta<V> a : bucketArestas.get(origem)){
            if( a.getOrigem().equals(origem)&& a.getDestino().equals(destino) ){
>>>>>>> ebffaf5d601ececc83ddd6c5871494ba41fca061:src/util/Grafo.java
                return true;
            }
        }
        return false;
    }
<<<<<<< HEAD:src/util/util/Grafo.java
    
    /**
     * Calcula o grau do vértice!
     * @param vertice
     * @return	quantidade de vértices adjacentes ao vértice passado como parâmetro
     * @throws NotVerticeException
     */
    int grauDoVertice(V vertice) throws NotVerticeException{
 
        if(!vertices.contains(vertice))
=======

    public int grauDoVertice(V vertice) throws NotVerticeException{
        int indexOrigem = vertices.indexOf(vertice);
        if(indexOrigem<0)
>>>>>>> ebffaf5d601ececc83ddd6c5871494ba41fca061:src/util/Grafo.java
            throw new NotVerticeException();
        int num = 0;
        for(Aresta<V> a: arestas){
            if(a.getDestino().equals(vertice)){
                num++;
            }
        }
        return num;
    }

    public int numeroDeArestas(){
        return arestas.size();
    }

    public int numeroDeVertices(){
        return vertices.size();
    }
<<<<<<< HEAD:src/util/util/Grafo.java
               
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
=======
    
    public ArrayList<ArrayList<Aresta>> caminhos(V origem, V destino){
        return null;
>>>>>>> ebffaf5d601ececc83ddd6c5871494ba41fca061:src/util/Grafo.java
    }
    
    public ArrayList<Aresta<V>> menorCaminho(V origem, V destino) throws NotPathException{
        if(!this.containsVertice(origem)||!this.containsVertice(destino))
            return null;
        HashMap<V, Double> distanceMap = new HashMap<>();
        HashSet<V> passados = new HashSet();
        HashSet<V> naoPassados = new HashSet();
        distanceMap.put(origem, new Double(0));
        for(V vertice: vertices){
            naoPassados.add(vertice);
            if(!vertice.equals(origem))
                distanceMap.put(vertice, Double.MAX_VALUE);
        }
        
<<<<<<< HEAD:src/util/util/Grafo.java
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
=======
        HashMap<V, Aresta> caminhoNegado = new HashMap<>();
        
        while(!naoPassados.isEmpty()){
            V maisProximo = verticeMaisProximo(naoPassados, distanceMap);
            passados.add(maisProximo);
            naoPassados.remove(maisProximo);
            calcularDistancias(maisProximo,passados,distanceMap,caminhoNegado);
            
>>>>>>> ebffaf5d601ececc83ddd6c5871494ba41fca061:src/util/Grafo.java
        }
        ArrayList<Aresta<V>> ret = new ArrayList<>();
        V o = destino;
        while(!o.equals(origem)){
            Aresta<V> a = caminhoNegado.get(o);
            if(a == null)
                throw new NotPathException();
            ret.add(a);
            o = a.getOrigem();
        }
        return ret;
    }
    
    private V verticeMaisProximo(HashSet<V> naoPassados, HashMap<V, Double> distanceMap){
        V ret = null;
        Iterator i = naoPassados.iterator();
        while(i.hasNext()){
            if(ret == null)
                ret = (V) i.next();
            else{
                V vertice = (V) i.next();
                if(distanceMap.get(vertice)<distanceMap.get(ret))
                    ret = vertice;
            } 
        }
<<<<<<< HEAD:src/util/util/Grafo.java
        
        public ArrayList<Aresta> getArestas() {
        	return arestasV;
        }
        
        public void setArestas(ArrayList<Aresta> arestas) {
        	this.arestasV = arestas;
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
=======
        return ret;
    }
    
    private void calcularDistancias(V vertice, HashSet<V> passados, HashMap<V, Double> distanceMap, HashMap<V, Aresta> caminhoNegado){
        ArrayList<Aresta<V>> arestasVizinhos = bucketArestas.get(vertice);
        HashSet<V> passadosAgora = new HashSet<>();
        Double distanciaBase = distanceMap.get(vertice);
        for(Aresta<V> a: arestasVizinhos){
            if(!passados.contains(a.getDestino())){
                if(distanceMap.get(a.getDestino())>a.getPeso()+distanciaBase){
                    distanceMap.replace(a.getDestino(), distanciaBase+a.getPeso());
                    caminhoNegado.put(a.getDestino(), a);
                }
                //System.out.println("Vim de "+a.getOrigem()+" "+vertice+" e Passei em: "+ a.getDestino()+ " DistÃ¢ncia: " +(a.getPeso()+distanciaBase) +" DistÃ¢nciaNoMapa: "+ distanceMap.get(a.getDestino()));
                    
>>>>>>> ebffaf5d601ececc83ddd6c5871494ba41fca061:src/util/Grafo.java
            }
        }
<<<<<<< HEAD:src/util/util/Grafo.java
        
     /*   public boolean verticeEncontrado() {
        	this.setEncontrado();
        	return w.getEncontrado();
        }*/
=======
>>>>>>> ebffaf5d601ececc83ddd6c5871494ba41fca061:src/util/Grafo.java
    }
    
    private Aresta arestaMaisProxima(V origem, V destino){
        if(origem == null)
            return null;
        ArrayList<Aresta<V>> candidatas = bucketArestas.get(origem);
        Aresta<V> closer = null;
        for(Aresta<V> a: candidatas){
            if(a.getDestino().equals(destino)){
                if(closer == null)
                    closer = a;
                else if(a.compareTo(closer)<0)
                    closer = a;
            }
        }
<<<<<<< HEAD:src/util/util/Grafo.java
        
        public Vertice getOrigem() {
            return origem;
=======
        return closer;
    }

    public ArrayList<ArrayList<V>> getRotas(V origem, V destino) throws NotVerticeException {
        if(!vertices.contains(origem)||!vertices.contains(destino)){
            throw new NotVerticeException();
>>>>>>> ebffaf5d601ececc83ddd6c5871494ba41fca061:src/util/Grafo.java
        }
        HashMap<Double, ArrayList<V>> caminhos = new HashMap();
        HashSet<V> passados = new HashSet();
        HashSet<V> naoPassados = new HashSet();
        vertices.forEach((vertice)->{
            naoPassados.add(vertice);
        });
        
        ArrayList<Aresta<V>> adjacenciasOrigem = bucketArestas.get(origem);
        passados.add(origem);
        for(int i = 0; i<adjacenciasOrigem.size();i++){
            Aresta<V> aresta = adjacenciasOrigem.get(i);
            V adjacente = aresta.getDestino();
            ArrayList<V> caminhoAtual = new ArrayList();
            caminhoAtual.add(origem);
            buscaRecursiva(adjacente, destino, passados, naoPassados, caminhos, aresta.getPeso(),caminhoAtual);
        }
        ArrayList<ArrayList<V>> ret = new ArrayList();
        ArrayList<ComparablePath> retPaths = new ArrayList(caminhos.size());
        caminhos.forEach((Double u, ArrayList<V> t) -> {
            //System.out.println("Peso: "+u);
            retPaths.add(new ComparablePath(t, u));
        });
        
        sort(retPaths);
        for(int i = 0; i<retPaths.size(); i++){
            ret.add(retPaths.get(i).V);
        }
        return ret;
    }
    
    private void sort(ArrayList<ComparablePath> array){
        for (int i = 1; i < array.size(); i++) {
            ComparablePath current = array.get(i);
            int j = i - 1;
            while(j >= 0 && current.compareTo(array.get(j))<0) {
                array.set(j+1, array.get(j));
                j--;
            }
            array.set(j+1, current);
        }
    }
    
    private class ComparablePath implements Comparable{

        public ComparablePath(ArrayList<V> V, Double u) {
            this.V = V;
            this.u = u;
        }
        
        
        ArrayList<V> V;
        Double u;

        @Override
        public int compareTo(Object t) {
            return u.intValue()-((ComparablePath)t).u.intValue();
        }
    }
<<<<<<< HEAD:src/util/util/Grafo.java
=======
    
    
    
    private ArrayList<V> copiaDe(ArrayList<V> caminhoAtual){
        ArrayList<V> ret = new ArrayList();
        for(int i =0; i<caminhoAtual.size(); i++){
            ret.add(caminhoAtual.get(i));
        }
        return ret;
    }
    
    public void buscaRecursiva(V origem, V destino, HashSet<V> passados, HashSet<V> naoPassados, HashMap<Double, ArrayList<V>> caminhos, Double tamanho, ArrayList<V> caminhoAtual){
        if(origem.equals(destino)){
            ArrayList<V> ret = copiaDe(caminhoAtual);
            ret.add(origem);
            caminhos.put(tamanho,ret);
            return;
        }
        passados.add(origem);
        caminhoAtual.add(origem);
        bucketArestas.get(origem).forEach((aresta)->{
            V prox = aresta.getDestino();
            if(!passados.contains(prox)){
                buscaRecursiva(prox, destino, passados, naoPassados,caminhos, tamanho+aresta.getPeso(), copiaDe(caminhoAtual));
            }
            passados.remove(origem);
        });
    }    
    
>>>>>>> ebffaf5d601ececc83ddd6c5871494ba41fca061:src/util/Grafo.java
}
