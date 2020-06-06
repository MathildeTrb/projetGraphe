package exercice3;

public class Graphe {

	private int[][] matrice;
	private int dimension;

	public Graphe(int dimension) {
		this.dimension = dimension;
		this.matrice = new int[dimension][dimension];

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				matrice[i][j] = -1; // init à la valeur max possible pour représenter l'absence de chemin
			}
		}
	}

	public boolean ajouterChemin(int source, int destination, int valeur) {
		if (source != destination) {
			if (matrice[source][destination] == -1) {
					// ajout du chemin (orienté)
					this.matrice[source][destination] = valeur;
					return true;
			}
		}
		return false;
	}

	int distanceMinimal(boolean[] mst, int[] key) {
		int minKey = Integer.MAX_VALUE;
		int vertex = -1;
		for (int i = 0; i < dimension; i++) {
			if (mst[i] == false && minKey > key[i]) {
				minKey = key[i];
				vertex = i;
			}
		}
		return vertex;
	}

	public int[][] getMatrice() {
		return this.matrice;
	}

	public int getDimension() {
		return dimension;
	}

	public int getValue(int source, int dest) {
		return matrice[source][dest];
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
