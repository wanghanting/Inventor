package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Project: Inventor
 * @Description:
 * @Version: 1.0
 * @Copyright: Copyright (c) 2018
 * @University: University of Nice
 */
class InventorTest {
    Inventor inventor;
    @BeforeEach
    void setUp() {
        inventor = new Inventor("NEWTON");
    }

    @Test
    void setStateTrue() {
        inventor.setDisponible();
        boolean expected = true;
        boolean actual = inventor.getDisponible();
        assertEquals(expected,actual);
    }

    @Test
    void setStateFalse() {
        inventor.setIndisponsable();
        boolean expected = false;
        boolean actual = inventor.getDisponible();
        assertEquals(expected,actual);
    }
}