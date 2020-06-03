package exo3;


	public class Graphe {

		private int[][] matrice;
		private int n;

		public Graphe(int n) {
			this.n = n;
			this.matrice = new int[n][n];

			for (int i = 0; i < matrice.length; i++) {
				for (int j = 0; j < matrice.length; j++) {
					matrice[i][j] = -1; // init à -1 pour représenter l'absence de chemin
				}
			}
		}

		public void ajouterChemin(int source, int destination, int valeur) {
			// ajout du chemin (orienté)
			this.matrice[source][destination] = valeur;
			// ajout du chemin pour rendre le gaphe non orienté
			//this.matrice[destination][source] = valeur;
		}

		public int[][] getMatrice() {
			return this.matrice;
		}

		@Override
		public String toString() {
			String str = "   ";

			for (int i = 0; i < matrice.length; i++) {
				str += ("[" + i + "]");
			}

			for (int i = 0; i < matrice.length; i++) {
				str += ("\n[" + i + "]");
				for (int j = 0; j < matrice.length; j++) {
					if (matrice[i][j] < 0) {
						str += " " + "-" + " ";
					} else {
						str += " " + matrice[i][j] + " ";

					}
				}
			}
			return str;
		}

	}
	