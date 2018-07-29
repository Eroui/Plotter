package com.math.plotter.models.impl;

import com.math.plotter.models.Expression;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class MultiplicationTest {

    private final Random r = new Random();
    private final double error = 1e-9;

    @Test
    public void multiplicationTest() {
        double value1 = r.nextDouble();
        double value2 = r.nextDouble();

        Expression multiplication = new Multiplication(
                new Constant(value1),
                new Constant(value2)
        );

        assertEquals("Multiplication Test Failed",
                multiplication.value(r.nextDouble()),
                value1 * value2,
                error);
    }

    @Test
    public void multiplicationOfAdditionTest() {
        double value1 = r.nextDouble();
        double value2 = r.nextDouble();
        double value3 = r.nextDouble();
        double value4 = r.nextDouble();

        Expression multiplication1 = new Multiplication(
                new Constant(value1),
                new Addition(
                        new Constant(value2),
                        new Constant(value3)
                )
        );

        Expression multiplication2 = new Multiplication(
                new Addition(
                        new Constant(value1),
                        new Constant(value2)
                ),
                new Constant(value3)
        );

        Expression multiplication3 = new Multiplication(
                new Addition(
                        new Constant(value1),
                        new Constant(value2)
                ),
                new Addition(
                        new Constant(value3),
                        new Constant(value4)
                )
        );

        assertEquals("Failed Multiplication 1",
                multiplication1.value(r.nextDouble()),
                value1 * (value2 + value3),
                error);

        assertEquals("Failed Multiplication 2",
                multiplication2.value(r.nextDouble()),
                (value1 + value2) * value3,
                error);

        assertEquals("Failed Multiplication 3",
                multiplication3.value(r.nextDouble()),
                (value1 + value2) * (value3 + value4),
                error);
    }
}