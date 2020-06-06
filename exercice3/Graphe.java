package exercice3;

public class Graphe {

	private int[][] matrice;
	private int dimension;

	public Graphe(int dimension) {
		this.dimension = dimension;
		this.matrice = new int[dimension][dimension];

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				matrice[i][j] = -1; // init � la valeur max possible pour repr�senter l'absence de chemin
			}
		}
	}

	public boolean ajouterChemin(int source, int destination, int valeur) {
		if (source != destination) {
			if (matrice[source][destination] == -1) {
				// ajout du chemin (orient�)
				this.matrice[source][destination] = valeur;
				return true;
			}
		}
		return false;
	}

	public int[][] getMatrice() {
		return matrice;
	}

	@Override
	public String toString() {
		String str = "";

		for (int i = 0; i < dimension; i++) {
			str += ("\t[" + i + "]");
		}

		for (int i = 0; i < dimension; i++) {
			str += ("\n[" + i + "]");
			for (int j = 0; j < dimension; j++) {
				if (matrice[i][j] == -1) {
					str += "\t" + "-";
				} else {
					str += "\t" + matrice[i][j];
				}
			}
		}
		return str;
	}

}
