package exercice3;

import java.util.ArrayList;

public class PlusCourtChemin {


	public static void PlusCourtChemin(int[][] matriceAdjacence, int source) {

		// initialisation

		int[] peres = new int[matriceAdjacence.length]; // le tableau peres: � l'indice i se trouvera l'indice du noeud
														// pr�c�dent au noeud i dans le plus court chemin
		peres[source] = -1; // le p�re de 0 est lui m�me car c'est le noeud de d�part

		int[] distances = new int[matriceAdjacence.length]; // le tableau distances: � l'indice i se trouvera la
															// distance entre le noeud i et le noeud 0
		distances[source] = 0; // le noeud 0 se trouve � distance 0 de lui m�me

		// on initialise toutes les autres distances � l'infini
		for (int i = 0; i < matriceAdjacence.length; i++) {
			if (i != source) {
				distances[i] = Integer.MAX_VALUE;
			}
		}

		ArrayList<Integer> noeudsTraites = new ArrayList<Integer>(); // contient les noeud trait�s

		int NoeudEnCours = source; // On commence part le noeud 0

		boolean fin = false; // est-ce qu'on a trait� tous les sommets ?

		while (!fin) { // tant qu'on a pas trait� tous les sommets

			// traitement d'un sommet
			for (int i = 1; i < matriceAdjacence.length; i++) { // pour tous les arcs qui partent du noeud en cours de
																// traitement

				// si la distance depuis le sommet 0 au sommet i dans le tableau est sup�rieur �
				// la nouvelle distance trouv�e, on la remplace

				if ((distances[i] > matriceAdjacence[NoeudEnCours][i] + distances[NoeudEnCours])
						&& matriceAdjacence[NoeudEnCours][i] != -1 && distances[NoeudEnCours] != Integer.MAX_VALUE) { // si
																														// on
																														// a
																														// -1
																														// dans
																														// la
																														// matrice
																														// c'est
																														// qu'il
																														// n'y
																														// a
																														// pas
																														// d'arc
																														// entre
																														// les
																														// sommets
					distances[i] = matriceAdjacence[NoeudEnCours][i] + distances[NoeudEnCours];
					peres[i] = NoeudEnCours; // on met � jour le "p�re"
				}
			}
			noeudsTraites.add(NoeudEnCours); // je dis que j'ai trait� le noeud

			if (noeudsTraites.size() != matriceAdjacence.length) { // si il y a encore des noeud � traiter, je d�termine
				NoeudEnCours = NoeudSuivant(NoeudEnCours, matriceAdjacence, noeudsTraites);
			} else {
				fin = true;
			}
		}
		afficherChemin(peres, distances, source);
	}

	public static int NoeudSuivant(int NoeudEnCours, int[][] matriceAdjacence, ArrayList<Integer> noeudsTraites) {
		/*
		 * on initialise les variables � des valeurs "bidons" car elles vont
		 * obligatoirement �tre chang�e puisque avant d'appeler cette fonction, on
		 * v�rifie qu'il reste au moins un noeud � traiter
		 */
		int ponderationMin = Integer.MAX_VALUE;
		int res = -1;

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
		System.out.println("Mod�le : [Distance] : 'Destination' <- pere ... <-  pere <- 'Source' ");
		for (int i = 0; i < peres.length; i++) {
			int j = i;
			if (distances[i] != Integer.MAX_VALUE) {
				System.out.print("\n[" + distances[i] + "] : " + j);
				while (peres[j] != -1) {
					System.out.print(" <- " + peres[j]);
					j = peres[j];
				}
			}
		}
		System.out.print("\n");

	}

}
