package com.company;

public class Main {

    public static void main(String[] args) {
        Graphe graphe = new Graphe(7);
        graphe.ajouterChemin(0,1,2);
        graphe.ajouterChemin(0,6,5);
        graphe.ajouterChemin(1,6,15);
        graphe.ajouterChemin(6,2,5);
        graphe.ajouterChemin(6,3,3);
        graphe.ajouterChemin(1,4,3);
        graphe.ajouterChemin(1,3,10);
        graphe.ajouterChemin(2,3,7);
        graphe.ajouterChemin(2,4,10);
        graphe.ajouterChemin(2,5,12);
        graphe.ajouterChemin(5,4,11);
        graphe.ajouterChemin(3,4,1);
        System.out.println(graphe);
        System.out.println(ArbreCouvrantMin.afficheArbreMin(graphe));

    }
}
