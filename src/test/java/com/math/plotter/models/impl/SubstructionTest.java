package com.math.plotter.models.impl;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SubstructionTest {

    @Test
    public void substructionOfConstants() {
        Random r = new Random();

        double value1 = r.nextDouble();
        double value2 = r.nextDouble();

        Substruction substruction = new Substruction(
                new Constant(value1),
                new Constant(value2)
        );

        assertEquals("Substraction Failed Test",
                substruction.value(r.nextDouble()),
                value1 - value2,
                1e-9);
    }

    @Test
    public void substractionOfSubstruction() {
        Random r = new Random();
        double value1 = r.nextDouble();
        double value2 = r.nextDouble();

        Substruction substruction1 = new Substruction(
                new Substruction(new Constant(value1), new Constant(value2)),
                new Constant(value1)
        );

        Substruction substruction2 = new Substruction(
                new Constant(value1),
                new Substruction(new Constant(value1), new Constant(value2))
        );

        assertEquals("Substruction Failed Test 1",
                substruction1.value(r.nextDouble()),
                (value1 - value2) - value1,
                1e-9);

        assertEquals("Substruction Failed Test 2",
                substruction2.value(r.nextDouble()),
                value1 - (value1 - value2),
                1e-9);
    }
}