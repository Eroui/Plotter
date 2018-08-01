package com.math.plotter.models.impl;

import com.math.plotter.models.Expression;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class NegativeTest {

    final Random r = new Random();
    final double error = 1e-9;

    @Test
    public void negativeConstantTest() {
        double value = r.nextDouble();

        Expression negative = new Negative(new Constant(value));
        assertEquals("Failed Negative Constant Test",
                negative.value(r.nextDouble()),
                -1.0 * value,
                error);
    }

    @Test
    public void negativeVariableTest() {
        double value = r.nextDouble();

        Expression negative = new Negative(new Variable());
        assertEquals("Failed Negative Variable Test",
                negative.value(value),
                -1.0 * value,
                value);
    }

}