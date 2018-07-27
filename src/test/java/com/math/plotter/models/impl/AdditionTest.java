package com.math.plotter.models.impl;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class AdditionTest {

    @Test
    public void AdditionOfConstants() {
        Random r = new Random();
        double value1 = r.nextDouble();
        double value2 = r.nextDouble();
        Addition addition = new Addition(new Constant(value1), new Constant(value2));


        assertEquals("Addition Failed Test",
                addition.value(r.nextDouble()),
                value1 + value2,
                1e-9);
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
                1e-9);
    }
}