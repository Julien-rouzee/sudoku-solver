public class Sudoku {
    public static final int NB_LIGNES   = 9;
    public static final int NB_COLONNES = 9;
    public int[][] grille;


    // Constructeur
    public Sudoku(int[][] grille) {
        this.grille = grille;
    }

    public void afficheGrille()
    {
        for (int i = 0; i < NB_LIGNES; i++) {
            for (int j = 0; j < NB_COLONNES; j++) {
                System.out.print(this.grille[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //Fonction qui vérifie si le nombre est compris entre 0 et 9
    public boolean nombreValide(int nombre){
        if(nombre!=0 && nombre<=9)
            return true;
        return false;
    }

    // On vérifie si un nombre est dans une colonne
    public boolean estDansLaColonne(Colonne col, int nombre) {
        for (int i = 0; i < NB_COLONNES; i++)
            if (grille[i][col.getColonne()] == nombre && nombreValide(nombre))
                return true;

        return false;
    }

    // On vérifie si un nombre est dans une ligne
    public boolean estDansLaLigne(Ligne ligne, int nombre) {
        for (int i = 0; i < NB_COLONNES; i++)
            if (grille[i][ligne.getLigne()] == nombre && nombreValide(nombre))
                return true;

        return false;
    }

    // On vérifie si un nombre est dans un carré donné
    public boolean estDansLeCarré(Ligne ligne, Colonne colonne, int nombre) {
        int l = ligne.getLigne() - ligne.getLigne() % 3;
        int c = colonne.getColonne() - colonne.getColonne() % 3;

        for (int i = l; i < l + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (grille[i][j] == nombre && nombreValide(nombre))
                    return true;

        return false;
    }
}
