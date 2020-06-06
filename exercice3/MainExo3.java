package exercice3;

import java.util.Random;
import java.util.Scanner;

public class MainExo3 {

	public static void main(String[] args) {

		long startTime;
		long tempsExecution;

		int nbSommets;
		int nbChemins;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Veuillez saisir le nombre de sommet : ");
			nbSommets = sc.nextInt();
		} while (nbSommets < 0 || nbSommets > 1000);

		int test;
		// limit� � 1000 pour �viter d'avoir des erreurs erreurs
		do {
			System.out.println("Veuillez saisir le nombre de chemin : ");
			nbChemins = sc.nextInt();
		} while (nbChemins < 0 || nbChemins > 50000);
		// limit�s � 50000 pour �viter d'avoir des erreurs

		System.out.println("\n\n");

		startTime = System.currentTimeMillis();
		Graphe graph = new Graphe(nbSommets);
		Random r = new Random();
		int i = 0;
		while (i < nbChemins) {
			int source = r.nextInt(nbSommets); // chox d'un sommet source al�atoire (entre 0 et nbSommet)
			int destination = r.nextInt(nbSommets); // choix d'un sommet destination al�atoire (entre 0 et nbSommet)
			int ponderation = r.nextInt(100)+1; // choix d'une pond�ration al�atoire (limit� � 100)
			if (graph.ajouterChemin(source, destination, ponderation)) {
				i++;
			}
		}
		tempsExecution = System.currentTimeMillis() - startTime;
		System.out.println("[Cr�ation graphe] Temps d'execution : " + tempsExecution + "ms");
		
		System.out.println("\n\n");

		System.out.println(graph.toString());

		System.out.println("\n\n");

		PlusCourtChemin.PlusCourtChemin(graph.getMatrice(), 2);
		
	}

}
