import java.util.ArrayList;

public class Ligne {
    ArrayList<Case> listeC = new ArrayList<Case>();

    public void add(Case c) {
        listeC.add(c);
    }


    public String toString() {
        String res = "";
        for (Case i:listeC){
            res =  res  + " " + i
                    + "";
        }
        return "Ligne{" +
                "listeC=" + res +
                '}' + '\n';
    }
}
