package controller;

import model.*;

import static model.Type.*;

/**
 * @Project: Inventor
 * @Description:
 * @Version: 1.0
 * @Copyright: Copyright (c) 2018
 * @University: University of Nice
 */
public class Game {
    Robot robot1;
    Invention[] Stage1inventions;
    Invention[] Stage2inventions;
    Invention[] Stage3inventions;
    Inventor[] inventors1;
    RobotAI robot2;
    Inventor[] inventors2;

    //Game Control
    void init() {
        initInventors();
        initInventions(0);
        robot1 = new Robot("Toto", inventors1);
        robot1.show();
        robot2 = new RobotAI("Foo", inventors2);
        robot2.show();
        showInventions(Stage1inventions);
    }
    void chooseOneTime(int stage) {
        showStage(stage);
        //chose stage inventions
        Invention[] inventions = chooseStageInventions(stage);
        //check if all indisponible
        if (robot1.checkAllIndisponible()) {
            robot1.reDisponibleInventors();
        } else {
            robot1.chooseInvention(robot1.chooseInventor(), inventions);
        }
        if (robot2.checkAllIndisponible()) {
            robot2.reDisponibleInventors();
        } else {
            robot2.chooseInventionWithAI(robot2.chooseInventor(), inventions);
        }
        System.out.println("******************** After choose ********************");
        robot1.show();
        robot2.show();
        showInventions(inventions);
    }
    Invention[] chooseStageInventions(int stage) {
        //chose stage inventions
        switch (stage) {
            case 0:
                return Stage1inventions;
            case 1:
                return Stage2inventions;
            default:
                return Stage3inventions;
        }
    }
    int getNextStage(int stage) {
        //chose stage inventions
        Invention[] inventions = chooseStageInventions(stage);
        for (Invention invention : inventions) {
            if (!invention.isFinish()) {
                return stage;
            }
        }
        return stage + 1;
    }

    //init data
    void initInventors() {
        int[] ability1 = {PHYSICS[1], CHIMIE[1], MECANIQUE[1], MATHEMATIQUE[1]};
        int[] ability2 = {PHYSICS[2], CHIMIE[2], MECANIQUE[2], MATHEMATIQUE[2]};
        int[] ability3 = {PHYSICS[3], CHIMIE[3], MECANIQUE[3], MATHEMATIQUE[3]};
        int[] ability4 = {PHYSICS[4], CHIMIE[4], MECANIQUE[4], MATHEMATIQUE[4]};
        inventors1 = new Inventor[4];
        inventors1[NEWTON] = new Inventor("NEWTON", ability1);
        inventors1[HAWKING] = new Inventor("HAWKING", ability2);
        inventors1[EINSTEIN] = new Inventor("EINSTEIN", ability3);
        inventors1[CURIE] = new Inventor("CURIE", ability4);
        int[] ability5 = {PHYSICS[1], CHIMIE[1], MECANIQUE[1], MATHEMATIQUE[1]};
        int[] ability6 = {PHYSICS[2], CHIMIE[2], MECANIQUE[2], MATHEMATIQUE[2]};
        int[] ability7 = {PHYSICS[3], CHIMIE[3], MECANIQUE[3], MATHEMATIQUE[3]};
        int[] ability8 = {PHYSICS[4], CHIMIE[4], MECANIQUE[4], MATHEMATIQUE[4]};
        inventors2 = new Inventor[4];
        inventors2[NIETZSCHE] = new Inventor("NIETZSCHE", ability5);
        inventors2[EDISON] = new Inventor("EDISON", ability6);
        inventors2[WATT] = new Inventor("WATT", ability7);
        inventors2[YUXIN] = new Inventor("YUXIN", ability8);
    }
    void initInventions(int stage) {
        //Stage One
        int[] Stage1require1 = {PHYSICS[1], CHIMIE[1], MECANIQUE[1], MATHEMATIQUE[1]};
        int[] Stage1require2 = {PHYSICS[2], CHIMIE[2], MECANIQUE[2], MATHEMATIQUE[2]};
        int[] Stage1require3 = {PHYSICS[3], CHIMIE[3], MECANIQUE[3], MATHEMATIQUE[3]};
        int[] Stage1require4 = {PHYSICS[4], CHIMIE[4], MECANIQUE[4], MATHEMATIQUE[4]};
        Bonus[] bonuses1 = new Bonus[2];
        bonuses1[ADDABLILITY] = new Bonus(ADDABLILITY,ABILITY[1]);
        bonuses1[ADDPOINT] = new Bonus(ADDPOINT, POINT[1]);
        Stage1inventions = new Invention[4];
        Stage1inventions[CAR] = new Invention("Car", Stage1require1, POINT[2],bonuses1);
        Stage1inventions[BUS] = new Invention("Bus", Stage1require2, POINT[1],bonuses1);
        Stage1inventions[SHIP] = new Invention("Ship", Stage1require3, POINT[3],bonuses1);
        Stage1inventions[PLANE] = new Invention("Plane", Stage1require4, POINT[1],bonuses1);
        //Stage Two
        int[] Stage2require1 = {PHYSICS[2], CHIMIE[2], MECANIQUE[3], MATHEMATIQUE[3]};
        int[] Stage2require2 = {PHYSICS[3], CHIMIE[3], MECANIQUE[4], MATHEMATIQUE[4]};
        int[] Stage2require3 = {PHYSICS[4], CHIMIE[4], MECANIQUE[5], MATHEMATIQUE[5]};
        int[] Stage2require4 = {PHYSICS[5], CHIMIE[5], MECANIQUE[6], MATHEMATIQUE[6]};
        Bonus[] bonuses2 = new Bonus[2];
        bonuses2[ADDABLILITY] = new Bonus(ADDABLILITY,ABILITY[2]);
        bonuses2[ADDPOINT] = new Bonus(ADDPOINT, POINT[2]);
        Stage2inventions = new Invention[4];
        Stage2inventions[AKM] = new Invention("AKM", Stage2require1, POINT[2],bonuses2);
        Stage2inventions[M16A4] = new Invention("M16A4", Stage2require2, POINT[3],bonuses2);
        Stage2inventions[M4A1] = new Invention("M4A1", Stage2require3, POINT[2],bonuses2);
        Stage2inventions[SCAR] = new Invention("SCAR", Stage2require4, POINT[3],bonuses2);
        //Stage Three
        int[] Stage3require1 = {PHYSICS[2], CHIMIE[3], MECANIQUE[4], MATHEMATIQUE[5]};
        int[] Stage3require2 = {PHYSICS[3], CHIMIE[4], MECANIQUE[5], MATHEMATIQUE[6]};
        int[] Stage3require3 = {PHYSICS[4], CHIMIE[5], MECANIQUE[6], MATHEMATIQUE[7]};
        int[] Stage3require4 = {PHYSICS[5], CHIMIE[6], MECANIQUE[7], MATHEMATIQUE[8]};
        Bonus[] bonuses3 = new Bonus[2];
        bonuses3[ADDABLILITY] = new Bonus(ADDABLILITY,ABILITY[3]);
        bonuses3[ADDPOINT] = new Bonus(ADDPOINT, POINT[3]);
        Stage3inventions = new Invention[4];
        Stage3inventions[AWM] = new Invention("AWM", Stage3require1, POINT[4],bonuses3);
        Stage3inventions[AUG] = new Invention("AUG", Stage3require2, POINT[3],bonuses3);
        Stage3inventions[GROZA] = new Invention("GROZA", Stage3require3, POINT[5],bonuses3);
        Stage3inventions[M24] = new Invention("M24", Stage3require4, POINT[3],bonuses3);
    }

    //show result
    int compareWhoIsWinner() {
        if (robot1.getPoint() > robot2.getPoint()) {
            return 1;
        } else {
            return 2;
        }
    }
    void showStage(int stage) {
        System.out.println("********************* --Stage " + ++stage + "-- *********************");
    }
    void showInventions(Invention[] inventions) {
        System.out.println("********************* --Inventions-- *********************");
        for (Invention invention : inventions) {
            invention.show();
        }
    }
    void showResult() {
        System.out.println("");
        System.out.println("The result is :");
        System.out.println("The score of Player1 is :" + robot1.getPoint());
        System.out.println("The score of Player2 is :" + robot2.getPoint());
        switch (compareWhoIsWinner()) {
            case 1:
                System.out.println("Player1 win the game with the score " + robot1.getPoint());
                break;
            case 2:
                System.out.println("Player2 win the game with the score " + robot2.getPoint());
                break;
            default:break;
        }

        System.out.println("Congratulations ! Thanks to WANG Hanting; ZHANG Yuxin; YU Teng");
    }
}
