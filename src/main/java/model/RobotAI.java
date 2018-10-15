package model;

/**
 * @Project: Inventeur
 * @Author: YU Teng
 * @Description:
 * @Version: 1.0
 * @Copyright: Copyright (c) 2018
 * @University: University of Nice
 */
public class RobotAI extends Robot {
    public RobotAI(String name, Inventor[] inventors) {
        super(name, inventors);
    }

    public boolean chooseInventionWithAI(Inventor inventor,Invention[] inventions) {
        int index = -1;
        int tmpPoint = 0;
        for (int i = 0; i < inventions.length; i++) {
            if (inventions[i].getDisponible() && inventions[i].getPoint() > tmpPoint) {
                index = i;
                tmpPoint = inventions[i].getPoint();
            }
        }
        if (index > -1) {
            inventions[index].requireMinAbility(inventor);
            if (inventions[index].isFinish()) {
                Bonus bonus = selectBonus(inventions[index]);
                inventions[index].setIndisponible();
                addPoint(tmpPoint);
                addBonus(inventor, bonus);
            }
            return true;
        }
        return false;
    }
}
