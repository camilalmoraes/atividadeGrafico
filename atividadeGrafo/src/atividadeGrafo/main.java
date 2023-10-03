package atividadeGrafo;

public class main{
	  
	public static void main(String[] args){
	        
		System.out.println("Gerando uma Matriz de Adjacencia: ");

			matriz grafoMatriz = new matriz(4);
			grafoMatriz.adicionaAresta(0, 1, 2);
			grafoMatriz.adicionaAresta(1, 3, 2);
			grafoMatriz.adicionaAresta(1, 2, 3);
			grafoMatriz.adicionaAresta(0, 3, 4);
			grafoMatriz.printaMatriz();
		
			System.out.println(" ");
		    System.out.println("O número de vertice é: " + grafoMatriz.numeroVertice());
		    
			System.out.println(" ");
			System.out.println("Gerando uma Lista de Adjacencia: ");

		    int numeroVertice = 5;
		    lista grafoLista = new lista(numeroVertice);

	        grafoLista.adicionarAresta(0, 1);
	        grafoLista.adicionarAresta(0, 4);
	        grafoLista.adicionarAresta(1, 2);
	        grafoLista.adicionarAresta(4, 3);

	        grafoLista.imprimirGrafo();
	        
	        int verticeInicio = 0;

	        grafoMatriz.buscaEmLargura(verticeInicio);
	    }
}
  
