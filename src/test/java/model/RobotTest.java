package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Type.*;
import static model.Type.ADDPOINT;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Project: Inventor
 * @Description:
 * @Version: 1.0
 * @Copyright: Copyright (c) 2018
 * @University: University of Nice
 */
class RobotTest {
    Robot robot;
    Inventor[] inventors;
    Bonus[] bonuses = new Bonus[2];

    @BeforeEach
    void setUp() {
        int[] ability={PHYSICS[2], CHIMIE[2], MECANIQUE[2], MATHEMATIQUE[2]};
        inventors= new Inventor[1];
        inventors[0] = new Inventor("NEWTON",ability);
        robot = new Robot("r1", inventors);

        bonuses[ADDABLILITY] = new Bonus(ADDABLILITY,ABILITY[1]);
        bonuses[ADDPOINT] = new Bonus(ADDPOINT, POINT[1]);
    }

    @Test
    void addPoint() {
        robot.addPoint(1);
        int expected = 1;
        int actual = robot.getPoint();
        assertEquals(expected,actual);
    }

    @Test
    void chooseInventor() {
        Inventor expected = inventors[0];
        Inventor actual = robot.chooseInventor();
        assertEquals(expected,actual);
    }

    @Test
    void chooseInventionDisponible() {

        int[] require={PHYSICS[2], CHIMIE[2], MECANIQUE[2], MATHEMATIQUE[2]};
        Invention[] inventions = new Invention[1];
        inventions[0] = new Invention("Avion", require,POINT[2],bonuses);
        boolean expected = true;
        boolean actual = robot.chooseInvention(robot.chooseInventor(),inventions);
        assertEquals(expected,actual);
    }

    @Test
    void chooseInventionIndisponible() {
        int[] require={PHYSICS[0], CHIMIE[0], MECANIQUE[0], MATHEMATIQUE[0]};
        Invention[] inventions = new Invention[1];
        inventions[0] = new Invention("Avion", require);
        inventions[0].setIndisponible();
        boolean expected = false;
        boolean actual = robot.chooseInvention(robot.chooseInventor(),inventions);
        assertEquals(expected,actual);
    }

    @Test
    void checkAllIndisponibleTrue() {
        robot.chooseInventor();
        boolean expected = true;
        boolean actual = robot.checkAllIndisponible();
        assertEquals(expected,actual);
    }
    @Test
    void checkAllIndisponibleFalse() {
        robot.reDisponibleInventors();
        boolean expected = false;
        boolean actual = robot.checkAllIndisponible();
        assertEquals(expected,actual);
    }

}