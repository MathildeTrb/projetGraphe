package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class ArbreCouvrantMin {

    public static int[] rechercheArbre (Graphe graphe){

        int taille = graphe.getMatrice().length;

        /* ce tableau comporte les pères de chaque sommet pendant la recherche de l'arbre couvrant minimal*/
        /* fils = indice du tableau, pere = valeur dans le tableau */
        int[] pere = new int[taille];
        ArrayList <Integer> visite = new ArrayList<>();

        // le sommet 0 est mon point de départ
        pere[0] = -1;
        visite.add(0);

        int cpt = 1;
        while (cpt < taille){

            /* je parcours les sommets que j'ai visité */
            Iterator<Integer> iterPere = visite.iterator();
            int poidMin = Integer.MAX_VALUE;
            int pereRet = -1;
            int filsRet = -1;
            while(iterPere.hasNext()){
                int pereCourant = iterPere.next();

                /* je récupère les sommets adjacents */
                ArrayList <Integer> adj = graphe.getAdj(pereCourant);

                /* je parcours les sommets adjacents */
                Iterator<Integer> iterAdj = adj.iterator();
                while(iterAdj.hasNext()){
                    int filsCourant = iterAdj.next();

                    /* si le poids minimal actuel est plus plus grand que la pondération entre le père et le fils courant
                    et si l'arc traverse la coupure */
                    if (poidMin > graphe.getValue(pereCourant, filsCourant) && !visite.contains(filsCourant)){
                        poidMin = graphe.getValue(pereCourant, filsCourant);
                        pereRet = pereCourant;
                        filsRet = filsCourant;
                    }
                }
            }
            if (filsRet != -1){
                visite.add(filsRet);
                pere[filsRet] = pereRet;
            }
            /* cas ou le graphe n'est pas connexe */
            if (pereRet == -1){
                int [] res = new int[1];
                return res;
            }
            cpt = cpt + 1;
        }
    return pere;
    }

    /*fonction qui affiche l'arbre couvrant minimal et renvoie sa pondération total */
    public static int afficheArbreMin (Graphe graphe){

        /*if (ArbreCouvrantMin.estConnexe(graphe) != 1){
            System.out.println("l'arbre n'est pas connexe");
            return 0;
        } idée de départ pour vérifier que le graphe était connexe mais pas du tout optimal */

        int [] res = rechercheArbre(graphe);

        /* si le graphe n'est pas connexe je ne trouve pas d'arbre couvrant minimal */
        if (res.length == 1){
            System.out.println("graphe non connexe");
            return 0;
        }

        int poidsFinal = 0;
        StringBuilder str = new StringBuilder();
        str.append("voici l'arbre courant minimal : ");
        for (int i = 1; i < res.length; i++){
            str.append("(" + res[i] + " ; " + i + ")");
            poidsFinal = poidsFinal + graphe.getValue(res[i], i);
        }
        System.out.println(str);
        return poidsFinal;
    }
}
