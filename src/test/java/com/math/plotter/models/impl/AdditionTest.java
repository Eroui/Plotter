package com.math.plotter.models.impl;

import com.math.plotter.models.Expression;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class AdditionTest {

    private final Random r = new Random();
    private final Double error = 1e-9;

    @Test
    public void AdditionOfConstants() {
        Random r = new Random();
        double value1 = r.nextDouble();
        double value2 = r.nextDouble();
        Addition addition = new Addition(new Constant(value1), new Constant(value2));


        assertEquals("Addition Failed Test",
                addition.value(r.nextDouble()),
                value1 + value2,
                error);
    }

    @Test
    public void AdditionOfAddition() {
        Random r = new Random();
        double value = r.nextDouble();
        Addition addition = new Addition(
                new Addition(new Constant(value), new Constant(value)),
                new Constant(value)
        );

        assertEquals("Addition Of Addition Failed Test",
                addition.value(r.nextDouble()),
                value + value + value,
                error);
    }

    @Test
    public void AdditionOfVariable() {
        double value = r.nextDouble();
        Expression addition = new Addition(
                new Variable(),
                new Variable()
        );

        assertEquals("Failed Addition of Variable Test",
                addition.value(value),
                value + value,
                error);
    }
}