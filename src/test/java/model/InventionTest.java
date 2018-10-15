package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventionTest {
    Invention invention;
    @BeforeEach
    void setUp() {
        invention = new Invention("Physics");
    }

    @Test
    void setDisponible() {
        invention.setDisponible();
        boolean expected = true;
        boolean actual = invention.getDisponible();
        assertEquals(expected,actual);
    }

    @Test
    void setIndisponible() {
        invention.setIndisponible();
        boolean expected = false;
        boolean actual = invention.getDisponible();
        assertEquals(expected,actual);
    }

    @Test
    void isFinish() {
        int[] require = {0, 0, 0, 0};
        invention = new Invention("Car", require);
        boolean expected = true;
        boolean actual = invention.isFinish();
        assertEquals(expected,actual);
    }

    @Test
    void isNotFinish() {
        int[] require = {0, 1, 0, 0};
        invention = new Invention("Car", require);
        boolean expected = false;
        boolean actual = invention.isFinish();
        assertEquals(expected,actual);
    }

}