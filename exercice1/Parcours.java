package exercice1;

import java.util.LinkedList;

public class Parcours {

	public static String estConnexe(Graphe graph) {

		int sommet = graph.sommet;
		int nbComposantes = 1;
		int source = 0;
		boolean end = false;
		
		LinkedList<Integer> adjacents[] = graph.graphe;
		boolean[] visites = new boolean[sommet];
		
		while (!end) {
			parcoursProfondeur(source, adjacents, visites);

			//permet de compter le nombre de composantes connexes
			for (int i = 0; i < visites.length; i++) {
				//si un sommet n'est pas marqu� alors il y a plusieurs compoasntes connexes
				if (!visites[i]) {
					nbComposantes++;
					source = i;	//recup�re le sommet qui ne fait pas parti d'une composante connexe
					end = false;
					break;
				} else {
					//ce end est � true ssi tous les sommets sont marqu�s
					end = true;
				}
			}

		}
		
		if(nbComposantes == 1) {
			return "Le graphe est connexe";
		} else {
			return "Le graphe poss�de " + nbComposantes + " composantes connexes ";
		}
	}

	private static void parcoursProfondeur(int source, LinkedList<Integer> sommetAdj[], boolean[] visites) {
		visites[source] = true;

		for (int i = 0; i < sommetAdj[source].size(); i++) {
			int suivant = sommetAdj[source].get(i);
			if (visites[suivant] == false) {
				parcoursProfondeur(suivant, sommetAdj, visites);
			}
		}
	}
}
