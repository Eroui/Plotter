package com.math.plotter.models.impl;

import com.math.plotter.models.Expression;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class DivisionTest {

    private final Random r = new Random();
    private final Double error = 1e-9;
    @Test
    public void DivisionTest() {
        double value1 = r.nextDouble();
        double value2 = r.nextDouble(); // TODO Must be non null (!= 0)

        Expression division = new Division(
                new Constant(value1),
                new Constant(value2)
        );

        assertEquals("Failed Division Test",
                division.value(r.nextDouble()),
                value1 / value2,
                error);
    }
}