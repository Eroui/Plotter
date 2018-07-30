package com.math.plotter.models.impl;

import com.math.plotter.models.Expression;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class VariableTest {

    private final Random r = new Random();
    private final Double error = 1e-9;

    @Test
    public void variableTest() {
        Expression var = new Variable();

        double value = r.nextDouble();
        assertEquals(
                "Variable test Failed",
                var.value(value),
                value,
                error
        );
    }

}