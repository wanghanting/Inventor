package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Type.*;
import static model.Type.MATHEMATIQUE;
import static model.Type.POINT;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @Project: Inventeur
 * @Author: YU Teng
 * @Description:
 * @Version: 1.0
 * @Copyright: Copyright (c) 2018
 * @University: University of Nice
 */
class RobotAITest {

    RobotAI robot;
    Inventor[] inventors;
    Bonus[] bonuses = new Bonus[2];

    @BeforeEach
    void setUp() {
        int[] ability={PHYSICS[2], CHIMIE[2], MECANIQUE[2], MATHEMATIQUE[2]};
        inventors= new Inventor[1];
        inventors[0] = new Inventor("NEWTON",ability);
        robot = new RobotAI("r1", inventors);

        bonuses[ADDABLILITY] = new Bonus(ADDABLILITY,ABILITY[1]);
        bonuses[ADDPOINT] = new Bonus(ADDPOINT, POINT[1]);
    }

    @Test
    void chooseInventionWithAIDisponible() {
        int[] require={PHYSICS[2], CHIMIE[2], MECANIQUE[2], MATHEMATIQUE[2]};
        Invention[] inventions = new Invention[1];
        inventions[0] = new Invention("Avion", require, POINT[2],bonuses);
        boolean expected = true;
        boolean actual = robot.chooseInventionWithAI(robot.chooseInventor(),inventions);
        assertEquals(expected,actual);
    }

    @Test
    void chooseInventionWithAIIndisponible() {
        int[] require={PHYSICS[0], CHIMIE[0], MECANIQUE[0], MATHEMATIQUE[0]};
        Invention[] inventions = new Invention[1];
        inventions[0] = new Invention("Avion", require, POINT[2]);
        inventions[0].setIndisponible();
        boolean expected = false;
        boolean actual = robot.chooseInventionWithAI(robot.chooseInventor(),inventions);
        assertEquals(expected,actual);
    }

    @Test
    void chooseInventionWithAIHighPoint() {
        int[] require = {PHYSICS[2], CHIMIE[2], MECANIQUE[2], MATHEMATIQUE[2]};
        Invention[] inventions = new Invention[2];
        inventions[0] = new Invention("Avion", require, POINT[2],bonuses);
        inventions[1] = new Invention("Tank", require, POINT[5],bonuses);
        robot.chooseInventionWithAI(robot.chooseInventor(),inventions);
        int expected = 5;
        int actual = robot.getPoint();
        assertEquals(expected,actual);
    }
}