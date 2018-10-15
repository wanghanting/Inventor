package model;

import static model.Type.ADDABLILITY;

/**
 * @Project: Inventor
 * @Description:
 * @Version: 1.0
 * @Copyright: Copyright (c) 2018
 * @University: University of Nice
 */
public class Robot {
    String name;
    int point;
    Inventor[] inventors;
    public Robot(String name, Inventor[] inventors) {
        this.name = name;
        this.point = 0;
        this.inventors = inventors;
    }
    //Choose Method
    public Inventor chooseInventor() {
        for (Inventor inv : inventors) {
            if (inv.getDisponible()){
                inv.setIndisponsable();
                return inv;
            }
        }
        return null;
    }
    public boolean chooseInvention(Inventor inventor,Invention[] inventions) {
        for (Invention invention : inventions) {
            if (invention.getDisponible()){
                invention.requireMinAbility(inventor);
                if (invention.isFinish()) {
                    Bonus bonus = selectBonus(invention);
                    invention.setIndisponible();
                    addPoint(invention.getPoint());
                    addBonus(inventor, bonus);
                }
                return true;
            }
        }
        return false;
    }

    //bonus
    protected Bonus selectBonus(Invention invention) {
        double random = Math.random();
        if (random < 0.5) {
            return invention.getBonusAbility();
        } else {
            return invention.getBonusPoint();
        }
    }
    protected void addBonus(Inventor inventor, Bonus bonus) {
        if (bonus.getType() == ADDABLILITY) {
            inventor.addAbility(bonus.getValue());
        } else {
            point = point + bonus.getValue();
        }
    }

    public void reDisponibleInventors() {
        for (Inventor inventor : inventors) {
            inventor.setDisponible();
        }
    }
    //all inventor finish work
    public boolean checkAllIndisponible() {
        for (Inventor inventor : inventors) {
            if (inventor.getDisponible()) {
                return false;
            }
        }
        return true;
    }
    public void show() {
        System.out.println("//////////////////// I'am " + name +" Point: "+point+" \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
        for (Inventor inv : inventors) {
            inv.show();
        }
    }

    public void addPoint(int point) {
        this.point = this.point + point;
    }
    public int getPoint() {
        return point;
    }
}
