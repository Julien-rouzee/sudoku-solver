package sudokuSolver;

import javafx.util.Pair;

import java.util.ArrayList;

public class Grille {

    private Case[][] grille;

    public Grille()
    {

    }

    public Case[][] getGrille() {
        return grille;
    }

    public void setGrille(Case[][] grille) {
        this.grille = grille;
    }

    public void setGrille(int l,int c) {
        grille = new Case[l][c];
    }

    public void initGrille(int l, int c)
    {
        setGrille(l,c);
        for(int i = 0; i < l; i++)
        {
            for(int j = 0; j < c; j++)
            {
                grille[i][j] = new Case(i,j);

            }
        }
    }
    public void initGrilleJeu1()
            /*Initialisation de la grille avec un jeu trouvé sur internet*/
    {
        /*Ligne numero 0*/
        grille[0][0].setValeur(5);
        grille[0][1].setValeur(3);
        grille[0][4].setValeur(7);
        /*Ligne numero 1*/
        grille[1][0].setValeur(6);
        grille[1][3].setValeur(1);
        grille[1][4].setValeur(9);
        grille[1][5].setValeur(5);
        /*Ligne numero 2*/
        grille[2][1].setValeur(9);
        grille[2][2].setValeur(8);
        grille[2][7].setValeur(6);
        /*Ligne numero 3*/
        grille[3][0].setValeur(8);
        grille[3][4].setValeur(6);
        grille[3][8].setValeur(3);
        /*Ligne numero 4*/
        grille[4][0].setValeur(4);
        grille[4][3].setValeur(8);
        grille[4][5].setValeur(3);
        grille[4][8].setValeur(1);
        /*Ligne numero 5*/
        grille[5][0].setValeur(7);
        grille[5][4].setValeur(2);
        grille[5][8].setValeur(6);
        /*Ligne numero 6*/
        grille[6][1].setValeur(6);
        grille[6][6].setValeur(2);
        grille[6][7].setValeur(8);
        /*Ligne numero 7*/
        grille[7][3].setValeur(4);
        grille[7][4].setValeur(1);
        grille[7][5].setValeur(9);
        grille[7][8].setValeur(5);
        /*Ligne numero 8*/
        grille[8][4].setValeur(8);
        grille[8][7].setValeur(7);
        grille[8][8].setValeur(9);
    }

    public int nbLignes()
    {
        return grille.length;
    }

    public int nbColonnes()
    {
        if(nbLignes() < 1)
        {
            return 0;
        }else
        {
            return grille[0].length;
        }
    }

    public Case at(int l,int c)
    {
        return grille[l][c];
    }

    public void affichage()
    {
        StringBuilder str = new StringBuilder("      ");
        for(int i = 0; i < nbColonnes(); i++)
        {
            str.append(" ").append(i).append(" ");
        }
        str.append("\n");
        System.out.println(str.toString());

        str = new StringBuilder("");
        for(int i = 0; i < nbLignes(); i++)
        {
            str.append(" ").append(i).append("    ");
            for(int j = 0; j< nbColonnes(); j++)
            {
                str.append("|").append(grille[i][j].getValeur()).append("|");
            }
            System.out.println(str.toString());
            str = new StringBuilder("");
        }

    }

    public void miseAJourPossible()
    {
        System.out.println("Mise à jour...");
        Case actuelle;
        for(int i = 0; i < nbLignes(); i++)
        {
            for(int j = 0; j < nbColonnes(); j++)
            {
                actuelle = at(i,j);
                if(actuelle.estLibre())
                {
                    if(actuelle.encorePossible()) {
                        miseAJourLigne(actuelle);
                        miseAJourColonne(actuelle);
                        miseAJourCarre(actuelle);
                    }
                    else
                    {
                        System.out.println("Erreur, la case sur a ligne "+actuelle.getNumeroLigne()+" et la colonne "+actuelle.getNumeroColonne() +" n'a plus de possibilitees");
                        System.exit(1);

                    }
                }
            }
        }
    }

    private void miseAJourCarre(Case actuelle) { ;

        Pair<Integer,Integer> hautGauche = rechercheHautGauche(actuelle);
        Case courante;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                courante = grille[hautGauche.getKey() + i][hautGauche.getValue() + j];
                if(!courante.estLibre())//Si la case contient un numero
                {
                    if(actuelle.estPossible(courante.getValeur()))//Si ce numero est encore dans le liste des cases possible
                    {
                        actuelle.retirePossible(courante.getValeur());//on le retire
                    }
                }
            }
        }

    }

    private Pair<Integer, Integer> rechercheHautGauche(Case actuelle)
    {
        int ligneDansCarre = actuelle.getNumeroLigne() % 3;
        int colonneDansCarre = actuelle.getNumeroColonne() % 3;
        return new Pair<Integer, Integer>(actuelle.getNumeroLigne() - ligneDansCarre, actuelle.getNumeroColonne() - colonneDansCarre);

    }

    private void miseAJourColonne(Case actuelle) {
        Case courante;
        for(int i = 0; i < nbColonnes(); i++)
        {
            courante = grille[i][actuelle.getNumeroColonne()];
            if(!courante.estLibre())//Si la case contient un numero
            {
                if(actuelle.estPossible(courante.getValeur()))//Si ce numero est encore dans le liste des cases possible
                {
                    actuelle.retirePossible(courante.getValeur());//on le retire
                }
            }
        }
    }

    private void miseAJourLigne(Case actuelle) {
        Case courante;
        for(int i = 0; i < nbColonnes(); i++)
        {
            courante = grille[actuelle.getNumeroLigne()][i];
            if(!courante.estLibre())//Si la case contient un numero
            {
                if(actuelle.estPossible(courante.getValeur()))//Si ce numero est encore dans le liste des cases possible
                {
                    actuelle.retirePossible(courante.getValeur());//on le retire
                }
            }
        }
    }

    public void resoudre()
    {
        while(!resolu())
        {
            miseAJourPossible();

        }
    }

    private boolean resolu()
    {
        for(int i = 0; i < nbLignes(); i++)
        {
            for(int j = 0; j < nbColonnes(); j++)
            {
                if(at(i,j).estLibre())
                {
                    if(!at(i,j).encorePossible())
                    {
                        System.out.println("Erreur, une case libre n'a plus de possibilitées!");
                        System.exit(1);
                    }else
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
