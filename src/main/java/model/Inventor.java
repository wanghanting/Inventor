package model;

/**
 * @Project: Inventor
 * @Description:
 * @Version: 1.0
 * @Copyright: Copyright (c) 2018
 * @University: University of Nice
 */
public class Inventor {
    String name;
    boolean state;
    int[] ability;
    public Inventor(String name) {
        this.name = name;
        this.state = true;
    }
    public Inventor(String name,int[] ability) {
        this.name = name;
        this.state = true;
        this.ability = ability;
    }
    public void addAbility(int value) {
        double random = Math.random();
        if (random < 0.25) {
            //Physics
            ability[0] = ability[0] + value;
        } else if (random < 0.5) {
            //Chimie
            ability[1] = ability[1] + value;
        } else if (random < 0.75) {
            //Mecanique
            ability[2] = ability[2] + value;
        } else {
            //Mathematique
            ability[3] = ability[3] + value;
        }
    }
    public void show() {
        System.out.println("--------------------------");
        System.out.println("Inventor: " + name);
        if(state == true)
        {
            System.out.println("State: Dispobnible");
        }
        else{
            System.out.println("State: Indisponible");
        }
        System.out.println("Physics: " + ability[0] + "   Chimie: " + ability[1] + "   Mecanique: " + ability[2] + "   Mathematique: " + ability[3]);
    }

    public void setDisponible() {
        state = true;
    }
    public void setIndisponsable() {
        state = false;
    }
    public boolean getDisponible() {
        return state;
    }
}
