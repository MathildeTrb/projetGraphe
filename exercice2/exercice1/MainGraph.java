package exercice1;

public class MainGraph {

	public static void main(String[] args) {

		//defauts : si le graph est de taille x mais que le gprah ne contient pas x-1 sommet
		//alors le graph est toujours non connexe
		Graphe graph = new Graphe(7);
		graph.ajouterChemin(0, 1);
		graph.ajouterChemin(0, 4);
//		graph.ajouterChemin(1, 2);
		graph.ajouterChemin(1, 3);
		graph.ajouterChemin(1, 4);
//		graph.ajouterChemin(2, 3);
		graph.ajouterChemin(3, 4);
//		graph.ajouterChemin(4, 5);
		graph.ajouterChemin(5, 6);
		System.out.println(graph.afficherGraphe());
		System.out.println(Parcours.estConnexe(graph));
	}
}