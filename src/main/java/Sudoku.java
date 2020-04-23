import java.util.ArrayList;

public class Sudoku {
    ArrayList<Case> listeC = new ArrayList<Case>(); // Create an ArrayList object
    ArrayList<Ligne> ligne = new ArrayList<Ligne>();
    ArrayList<Colone> colone = new ArrayList<Colone>();
    ArrayList<Bloc> bloc = new ArrayList<Bloc>();

    public Sudoku(int[][] board) {
        for (int[] i : board) {
            Ligne l = new Ligne();
            ligne.add(l);
            for (int j : i) {

                Case c = new Case(j);
                l.add(c);
                c.setLigne(l);

                listeC.add(c);
                //System.out.println(c.getNumber());
            }
        }

        for (int i =0 ;  i < board.length; i++) {

            Colone col = new Colone();
            colone.add(col);
            for (int j =0 ;  j < board[i].length; j++) {

                Case c = listeC.get(j*board[i].length+i);
                col.add(c);
                c.setColone(col);


            }

        }

        for (int i =0 ;  i < board.length; i++) {
            Bloc b = new Bloc();
            bloc.add(b);
        }

        int p = 0 ;
        int max = 2;
        int min = 0;
        for (int i =0 ;  i < listeC.size(); i = i+3) {
           // System.out.println(p);

            //fonction a rendre dynamique
            bloc.get(p).add(listeC.get(i));
            listeC.get(i).setBloc(bloc.get(p));
            bloc.get(p).add(listeC.get(i+1));
            listeC.get(i+1).setBloc(bloc.get(p));

            bloc.get(p).add(listeC.get(i+2));
            listeC.get(i+2).setBloc(bloc.get(p));

            p = p+1 ;


            if ( p > max){
                System.out.println(bloc.get(p-1).listeC.size());
                if (bloc.get(p-1).listeC.size() == 9){
                    min = min + 3;
                    max = max + 3;
                }else{
                    p = min;
                }

            }




        }

    }

    public void resoudre1() {
        for (Case i : listeC){
            if (i.getNumber() == 0){
                i.setNumber(i.tryNumber());
                System.out.println(toString());

                for (Case j : listeC){
                    j.setPossible();
                }
            }

        }
    }


    @Override
    public String toString() {
        String res = "";
        for (int i =0 ; i< ligne.size() ; i++){
             for ( Case j : ligne.get(i).listeC){
                 res = res +  j.getNumber() + " ";
             }
             res  = res + "\n";
        }

        return "Sudoku{" + "\n" +
                res +
                '}';
    }
}
