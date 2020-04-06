package SS;

import java.util.ArrayList;

public abstract class Container {
    public ArrayList<Case> list;
    public int id;
    public Container(){
        this.list = new ArrayList<Case>();
    }
    public Container(ArrayList<Case> List){
        this.list = List;
    }
    public AvailablePossibilities getAvailablePossibililites(){
        AvailablePossibilities availablePossibilities = new AvailablePossibilities();
            this.list.stream().forEach(elt ->{
                if(elt.value != 0){
                    availablePossibilities.list[elt.value-1]=false;
                }
            });
        return availablePossibilities;
    }
    public AvailablePossibilities getAvailablePossibililites(AvailablePossibilities availablePossibilities){
        this.list.stream().forEach(elt ->{
            if(elt.value != 0){
                availablePossibilities.list[elt.value-1]=false;
            }
        });
        return availablePossibilities;
    }
    public void print(){
        this.list.stream().forEach(i -> {
            System.out.println(i.value);
        });
    }
    public boolean contain(int nb){
        boolean rtr = false;
        for(Case c : this.list){
            if(c.value == nb)rtr=true;
        }
        return rtr;
    }

}
