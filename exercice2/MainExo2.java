package exercice2;

public class MainExo2 {

	public static void main(String[] args) {
		Graphe graph = new Graphe(7);
		graph.ajouterChemin(0, 1, 2);
		graph.ajouterChemin(0, 4, 1);
//		graph.ajouterChemin(1, 2, 7);
		graph.ajouterChemin(1, 3, 2);
		graph.ajouterChemin(1, 4, 5);
//		graph.ajouterChemin(2, 3, 3);
		graph.ajouterChemin(3, 4, 6);
//		graph.ajouterChemin(4, 5, 10);
		graph.ajouterChemin(5, 6, 2);
		System.out.println(graph.toString());
//		System.out.println(Parcours.estConnexe(graph));
	}

}
