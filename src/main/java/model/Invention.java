package model;

import static model.Type.ADDABLILITY;
import static model.Type.ADDPOINT;

public class Invention {
    String name;
    boolean state;
    int point;
    int[] require;
    Bonus[] bonuses;
    public Invention(String name, int[] require, int point, Bonus[] bonuses) {
        this.name = name;
        this.state = true;
        this.require = require;
        this.point = point;
        this.bonuses = bonuses;
    }

    void requireMinAbility(Inventor inventor) {
        for (int i = 0; i < require.length; i++) {
            require[i] = require[i] - inventor.ability[i];
            if (require[i] < 0) {
                require[i]=0;
            }
        }
    }
    public boolean isFinish(){
        for (int i = 0; i < require.length; i++) {
            if (require[i] > 0) {
                return false;
            }
        }
        return true;
    }
    public void show() {
        System.out.println("--------------------------");
        System.out.println("Invention: " + name);
        if(state == true)
        {
            System.out.println("State: Dispobnible");
        }
        else{
            System.out.println("State: Indisponible");
        }
        System.out.println("Physics: " + require[0] + "   Chimie: " + require[1] + "   Mecanique: " + require[2] + "   Mathematique: " + require[3]);
    }

    public Invention(String name) {
        this.name = name;
        this.state = true;
    }
    public Invention(String name,int[] require) {
        this.name = name;
        this.state = true;
        this.require = require;
    }
    public Invention(String name,int[] require,int point) {
        this.name = name;
        this.state = true;
        this.require = require;
        this.point = point;
    }
    public void setDisponible() {
        state = true;
    }
    public void setIndisponible() {
        state = false;
    }
    public boolean getDisponible(){
        return state;
    }
    public int getPoint() {
        return point;
    }
    public Bonus getBonusAbility() {
        return bonuses[ADDABLILITY];
    }
    public Bonus getBonusPoint() {
        return bonuses[ADDPOINT];
    }
}
