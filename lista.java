package atividadeGrafo;

import java.util.*;

public class lista{
    private Map<Integer, List<Integer>> listaAdjacencia;

    public lista (int numeroVertice) {
        listaAdjacencia = new HashMap<>();
        for (int i = 0; i < numeroVertice; i++) {
            listaAdjacencia.put(i, new LinkedList<>());
        }
    }

    public void adicionarAresta(int origem, int destino) {
        listaAdjacencia.get(origem).add(destino);
        listaAdjacencia.get(destino).add(origem);
    }

    public List<Integer> obterVizinhos(int vertice) {
        return listaAdjacencia.get(vertice);
    }

    public void imprimirGrafo() {
        for (Map.Entry<Integer, List<Integer>> entry : listaAdjacencia.entrySet()) {
            System.out.print("O vértice " + entry.getKey() + " está conectado aos vértices: ");
            for (Integer vizinho : entry.getValue()) {
                System.out.print(vizinho + " ");
            }
            System.out.println();
        }
    }

}
