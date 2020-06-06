package exercice3;

import java.util.ArrayList;

public class PlusCourtChemin {

	public static void PlusCourtChemin(int[][] matriceAdjacence, int source) {

		// initialisation

		/*
		 * le tableau peres: à l'indice i se trouvera l'indice du noeud précédent au
		 * noeud i dans le plus court chemin
		 */
		int[] peres = new int[matriceAdjacence.length];
		peres[source] = -1; // le père de source est lui même car c'est le noeud de départ

		/*
		 * le tableau distances: à l'indice i se trouvera la distance entre le noeud i
		 * et le noeud source
		 */
		int[] distances = new int[matriceAdjacence.length];
		distances[source] = 0; // le noeud source se trouve à distance 0 de lui même

		// on initialise toutes les autres distances à l'infini
		for (int i = 0; i < matriceAdjacence.length; i++) {
			if (i != source) {
				distances[i] = Integer.MAX_VALUE;
			}
		}

		ArrayList<Integer> noeudsTraites = new ArrayList<Integer>(); // contient les noeud traités
		int NoeudEnCours = source; // On commence part le noeud source

		boolean fin = false; // est-ce qu'on a traité tous les sommets ?
		while (!fin) { // tant qu'on a pas traité tous les sommets

			// traitement d'un sommet
			for (int i = 1; i < matriceAdjacence.length; i++) { // pour tous les arcs qui partent du noeud en cours de
																// traitement

				/*
				 * si la distance depuis le sommet 0 au sommet i dans le tableau est supérieur à
				 * la nouvelle distance trouvée, on la remplace
				 * 
				 * si on a -1 dans la matrice c'est qu'il n'y a pas d'arc entre les sommets
				 */
				if (distances[i] > matriceAdjacence[NoeudEnCours][i] + distances[NoeudEnCours]
						&& matriceAdjacence[NoeudEnCours][i] != -1 && distances[NoeudEnCours] != Integer.MAX_VALUE) {
					distances[i] = matriceAdjacence[NoeudEnCours][i] + distances[NoeudEnCours];
					peres[i] = NoeudEnCours; // on met à jour le "père"
				}
			}
			noeudsTraites.add(NoeudEnCours); // je dis que j'ai traité le noeud

			if (noeudsTraites.size() != matriceAdjacence.length) { // si il y a encore des noeud à traiter, je détermine
				NoeudEnCours = NoeudSuivant(NoeudEnCours, matriceAdjacence, noeudsTraites);
			} else {
				fin = true;
			}
		}
		afficherChemin(peres, distances, source);
	}

	public static int NoeudSuivant(int NoeudEnCours, int[][] matriceAdjacence, ArrayList<Integer> noeudsTraites) {
		/*
		 * on initialise les variables à des valeurs "bidons" car elles vont
		 * obligatoirement être changée puisque avant d'appeler cette fonction, on
		 * vérifie qu'il reste au moins un noeud à traiter
		 */
		int ponderationMin = Integer.MAX_VALUE;
		int res = -1;

		/*
		 * On cherche la pondéarion min des arcs permettant d'accéder à un sommet depuis
		 * le sommet qu'on vient de traiter Le sommet ne doit pas déjà avoir été traité
		 */
		for (int i = 0; i < matriceAdjacence.length; i++) {
			if (!noeudsTraites.contains(i) && matriceAdjacence[NoeudEnCours][i] < ponderationMin) {
				ponderationMin = matriceAdjacence[NoeudEnCours][i];
				res = i;
			}
		}
		return res;
	}

	public static void afficherChemin(int[] peres, int[] distances, int source) {

		System.out.print("Voici les plus cours chemin en partant de :" + source);
		System.out.println("\nModèle : [Distance] : 'Destination' <- pere ... <-  pere <- 'Source' ");

		// Affichage du chemin minimal pour tous le sommets
		for (int i = 0; i < peres.length; i++) {
			int j = i;
			// On n'affiche pas les sommets dont la distance est INFINI car non accessible
			// depuis la source
			if (distances[i] != Integer.MAX_VALUE) {
				System.out.print("\n[" + distances[i] + "] : " + j);

				// On affiche le chemin en partant de la destination jusqu'à retourner à la
				// source
				while (peres[j] != -1) {
					System.out.print(" <- " + peres[j]);
					j = peres[j];
				}
			}
		}
	}

}
