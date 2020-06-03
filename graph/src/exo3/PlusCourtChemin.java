package exo3;

import java.util.ArrayList;

public class PlusCourtChemin {

	
	public static void PlusCourtChemin(int[][] matriceAdjacence) {
		
		//initialisation
	
		int[] peres = new int [matriceAdjacence.length]; //le tableau peres: à l'indice i se trouvera l'indice du noeud précédent au noeud i dans le plus court chemin
		peres[0] = -1; //le père de 0 est lui même car c'est le noeud de départ
		
		int[] distances = new int [matriceAdjacence.length]; //le tableau distances: à l'indice i se trouvera la distance entre le noeud i et le noeud 0
		distances[0] = 0; //le noeud 0 se trouve à distance 0 de lui même
		
		//on initialise toutes les autres distances à l'infini
		for(int i = 1; i < matriceAdjacence.length; i++) {
			distances[i] = Integer.MAX_VALUE; 
		}
		
		
		ArrayList<Integer> noeudsTraites = new ArrayList<Integer>(); //contient les noeud traités
		
		int NoeudEnCours = 0; //On commence part le noeud 0
		
		boolean fin = false; // est-ce qu'on a traité tous les sommets ?
		
		while(!fin) { //tant qu'on a pas traité tous les sommets
			
			//traitement d'un sommet
			for(int i = 1; i < matriceAdjacence.length; i++) { //pour tous les arcs qui partent du noeud en cours de traitement
				
				//si la distance depuis le sommet 0 au sommet i dans le tableau est supérieur à la nouvelle distance trouvée, on la remplace
				
				if((distances[i] > matriceAdjacence[NoeudEnCours][i] + distances[NoeudEnCours]) && matriceAdjacence[NoeudEnCours][i] != -1 ) { //si on a -1 dans la matrice c'est qu'il n'y a pas d'arc entre les sommets
					distances[i] = matriceAdjacence[NoeudEnCours][i] + distances[NoeudEnCours];
					peres[i] = NoeudEnCours; //on met à jour le "père"
				}
			}
			noeudsTraites.add(NoeudEnCours); //je dis que j'ai traité le noeud 
			
			if(noeudsTraites.size() != matriceAdjacence.length) { //si il y a encore des noeud à traiter, je détermine le suivant
				NoeudEnCours = NoeudSuivant(NoeudEnCours,matriceAdjacence,noeudsTraites);
			}else {
				fin = true;
			}
		}
		
		afficherChemin(peres);
	}
		public static  int NoeudSuivant(int NoeudEnCours,int[][] matriceAdjacence, ArrayList<Integer> noeudsTraites ) {
			/* on initialise les variables à des valeurs "bidons" 
			car elles vont obligatoirement être changée puisque avant d'appeler cette fonction,
			on vérifie qu'il reste au moins un noeud à traiter
			*/
			int ponderationMin = Integer.MAX_VALUE;
			int res = -1;
			
			for (int i = 0; i < matriceAdjacence.length; i++) {
				if(!noeudsTraites.contains(i) && matriceAdjacence[NoeudEnCours][i] < ponderationMin ) {
					ponderationMin = matriceAdjacence[NoeudEnCours][i];
					res = i;
				}
			}
			return res;
			
		}
		
		public static void afficherChemin(int[] peres) {
			
			System.out.print("Voici le plus cours chemin: \n 0 ");
			int nbSommetsAff = 1;
			int sommet = 0;
			
			while(nbSommetsAff != peres.length) {
				int i = 0;
				while(peres[i] != sommet) {
					i++;
				}
				System.out.print(" ->  " + i);
				nbSommetsAff++;
				sommet = i;
			}
			System.out.print("\n");
			
		}
		
	}
	

