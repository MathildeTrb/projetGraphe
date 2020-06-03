package exercice1;

import java.util.Random;

public class MainGraph {

	public static void main(String[] args) {

		int nbSommets = 10;
		int nbChemins = 20;
		
//		do {
//			nbChemins = 20;
//		} while(nbChemins < 0  || nbChemins > Math.sqrt(nbSommets));
		
		
		Graphe graph = new Graphe(nbSommets);
		
		Random r = new Random();
		for (int i = 0; i < nbChemins; i++) {
			int source = r.nextInt(nbSommets);
			int destination = r.nextInt(nbSommets);
			int pondération = r.nextInt(Integer.MAX_VALUE);
			graph.ajouterChemin(source, destination);
		}
		
		System.out.println(graph.afficherGraphe());
//		graph.ajouterChemin(0, 1);
//		graph.ajouterChemin(0, 4);
//		graph.ajouterChemin(1, 2);
//		graph.ajouterChemin(1, 3);
//		graph.ajouterChemin(1, 4);
//		graph.ajouterChemin(2, 3);
//		graph.ajouterChemin(3, 4);
//		graph.ajouterChemin(4, 5);
//		graph.ajouterChemin(5, 6);
//		System.out.println(graph.afficherGraphe());
//		System.out.println(Parcours.estConnexe(graph));
	}
}