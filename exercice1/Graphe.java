package exercice1;

import java.util.LinkedList;

public class Graphe {

	private int nbSommet;
	private LinkedList<Integer> graphe[];

	public Graphe(int nbSommet) {
		this.nbSommet = nbSommet;
		this.graphe = new LinkedList[nbSommet];

		for (int i = 0; i < nbSommet; i++) {
			graphe[i] = new LinkedList<>();
		}
	}

	public void ajouterChemin(int source, int destination) {
		//pour eviter d'avoir plusieurs représentation du meme chemin
		if (!graphe[destination].contains(source) && !graphe[source].contains(destination)) {
			// graphe orienté
			 graphe[source].addFirst(destination);
			// graphe non orienté si ajout de la ligne suivante
			graphe[destination].addFirst(source);
		}
	}

	public StringBuilder afficherGraphe() {
		StringBuilder str = new StringBuilder();

		// boucle sur tous les sommets du graphe
		for (int i = 0; i < nbSommet; i++) {

			// vérification que le sommet n'est pas vide
			if (!graphe[i].isEmpty()) {
				str.append("[" + i + "] -> ");

				// boucle sur chaque sommet adjacent de i
				for (Integer val : graphe[i]) {
					str.append(val + " ");
				}
				str.append("\n");
			}
		}
		return str;
	}
	
	
	public int getNbSommet() {
		return nbSommet;
	}
	
	public LinkedList<Integer>[] getGraphe() {
		return graphe;
	}
	 
}
