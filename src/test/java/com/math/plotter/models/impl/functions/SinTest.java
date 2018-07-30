package com.math.plotter.models.impl.functions;

import com.math.plotter.models.Expression;
import com.math.plotter.models.impl.Constant;
import com.math.plotter.models.impl.Variable;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class SinTest {

    private final Random r = new Random();
    private final double error = 1e-9;

    @Test
    public void sinOfConstantTest() {
        double value = r.nextDouble();
        Expression sin = new Sin(new Constant(value));

        assertEquals("Failed Sin of constant test",
                sin.value(r.nextDouble()),
                Math.sin(value),
                error);
    }

    @Test
    public void sinOfVariableTest() {
        double value = r.nextDouble();
        Expression sin = new Sin(new Variable());

        assertEquals("Failed Sin of Variable Test",
                sin.value(value),
                Math.sin(value),
                error);
    }
}