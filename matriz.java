package atividadeGrafo;


import java.util.*;

public class matriz {
    private int[][] matriz;
    private int numeroVertice;   

    public matriz (int numeroVertice){
        this.numeroVertice = numeroVertice;
        this.matriz = new int [numeroVertice][numeroVertice];
    }
    //Metodo para adicionar uma aresta
    public void adicionaAresta(int origem, int destino, int dado){
        matriz[origem][destino] = dado;
        matriz[destino][origem]= dado;
    }
    //Metodo para verificar a existencia de uma aresta
    public boolean verificaExistencia(int origem, int destino){
        return matriz[origem][destino] != 0;
    }
    //Metodo para remover uma aresta
    public void removeAresta(int origem, int destino){
        matriz[origem][destino] = 0;
        matriz[destino][origem] = 0;        
    }
    
    public int getDado(int origem, int destino){
        return matriz[origem][destino];
    }
    //Retorna o numero do vertice
    public int numeroVertice(){
        return numeroVertice;
    }
    //Metodo para imprimir a matriz
    public void printaMatriz(){
        int i;
        int j;
        for(i=0; i<numeroVertice; i++){
            for(j=0; j< numeroVertice; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
    //Implementando a busca em largura
    public void buscaEmLargura(int verticeInicio) {
    	
    	int vizinho;
    	int[] foiVisitado = new int[numeroVertice];
    	int[] anterior = new int[numeroVertice];	
    	Queue<Integer> fila = new LinkedList<>();
    	   
    		Arrays.fill(foiVisitado, 0);
    		Arrays.fill(anterior, -1);
    	    
    		foiVisitado[verticeInicio] = 1;
    	    fila.add(verticeInicio);

    	     System.out.println("Busca em Largura a partir do vértice " + verticeInicio + ":");

    	     while (!fila.isEmpty()) {
    	          int verticeAtual = fila.poll();

    	          	for (vizinho = 0; vizinho < numeroVertice; vizinho++) {
    	                if ((matriz[verticeAtual][vizinho] != 0 && foiVisitado[vizinho]==0)) {
    	                    foiVisitado[vizinho] = 1;
    	                    anterior[vizinho] = verticeAtual;
    	                    fila.add(vizinho);
    	                }
    	            }
    	       }
    	    
    	     int verticeDestino = 2;
    	     
    	     if(foiVisitado[verticeDestino] == 0) {
    	    	 System.out.println("Não existe um vertice destino válido, portanto não há um caminho");
    	     } else {
    	    		 System.out.println("Caminho entre os vértices " + verticeInicio + " e " + verticeDestino + ":");
    	             List<Integer> caminho = new ArrayList<>();
    	             caminho.add(verticeDestino);

    	             while (anterior[verticeDestino] != -1) {
    	                 verticeDestino = anterior[verticeDestino];
    	                 caminho.add(verticeDestino);
    	             }

    	             Collections.reverse(caminho);
    	             System.out.println(caminho);
    	         }
    	  
    }
    
    //Implementando a busca em profundidade
        public void buscaEmProfundidade(int verticeInicio, int verticeDestino) {
            int[] foiVisitado = new int[numeroVertice];
            int[] anterior = new int[numeroVertice];
            Stack<Integer> pilha = new Stack<>();

            Arrays.fill(foiVisitado, 0);
            Arrays.fill(anterior, -1);

            pilha.push(verticeInicio);
            foiVisitado[verticeInicio] = 1;

            System.out.println("Busca em Profundidade a partir do vértice " + verticeInicio + ":");

            while (!pilha.isEmpty()) {
                int verticeAtual = pilha.pop();

                for (int vizinho = 0; vizinho < numeroVertice; vizinho++) {
                    if (matriz[verticeAtual][vizinho] != 0 && foiVisitado[vizinho] == 0) {
                        foiVisitado[vizinho] = 1;
                        anterior[vizinho] = verticeAtual;
                        pilha.push(vizinho);

                        if (vizinho == verticeDestino) {
                            pilha.clear();
                            break;
                        }
                    }
                }
            }

            if (foiVisitado[verticeDestino] == 0) {
                System.out.println("Não existe um vértice destino válido, portanto não há um caminho.");
            } else {
                System.out.println("Caminho entre os vértices " + verticeInicio + " e " + verticeDestino + ":");
                List<Integer> caminho = new ArrayList<>();
                caminho.add(verticeDestino);

                while (anterior[verticeDestino] != -1) {
                    verticeDestino = anterior[verticeDestino];
                    caminho.add(verticeDestino);
                }

                Collections.reverse(caminho);
                System.out.println(caminho);
            }
        }
 }

