package exo3;

public class TestPlusCourtChemin {

	
	public static void main(String[] args) {
		//je crée un graph
		Graphe graphe = new Graphe(5);
		graphe.ajouterChemin(0,4,3);
		graphe.ajouterChemin(0,2,18);
		graphe.ajouterChemin(4,3,2);
		graphe.ajouterChemin(4,1,10);
		graphe.ajouterChemin(3,1,1);
		graphe.ajouterChemin(1,0,8);
		graphe.ajouterChemin(1,2,4);
		
		
		
		//je veut sa matrice d'adjacence
		int[][] matrice = graphe.getMatrice();
		
		//je veux le plus court chemin
		PlusCourtChemin.PlusCourtChemin(matrice);
	}
}
