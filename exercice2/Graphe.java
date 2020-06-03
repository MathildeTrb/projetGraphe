package exercice2;

public class Graphe {

	private int[][] matrice;
	private int n;

	public Graphe(int n) {
		this.n = n;
		this.matrice = new int[n][n];

		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice.length; j++) {
				matrice[i][j] = -1; // init � -1 pour repr�senter l'absence de chemin
			}
		}
	}

	public void ajouterChemin(int source, int destination, int valeur) {
		// ajout du chemin (orient�)
		this.matrice[source][destination] = valeur;
		// ajout du chemin pour rendre le gaphe non orient�
		this.matrice[destination][source] = valeur;
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
