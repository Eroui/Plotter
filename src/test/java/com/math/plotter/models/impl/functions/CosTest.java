package com.math.plotter.models.impl.functions;

import com.math.plotter.models.Expression;
import com.math.plotter.models.impl.Constant;
import com.math.plotter.models.impl.Variable;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class CosTest {

    private final Random r = new Random();
    private final double error = 1e-9;

    @Test
    public void cosOfConstantTest() {
        double value = r.nextDouble();
        Expression cos = new Cos(new Constant(value));

        assertEquals("Failed Cos of constant test",
                cos.value(r.nextDouble()),
                Math.cos(value),
                error);
    }

    @Test
    public void cosOfVariableTest() {
        double value = r.nextDouble();
        Expression cos = new Cos(new Variable());

        assertEquals("Failed Cos of Variable Test",
                cos.value(value),
                Math.cos(value),
                error);
    }
}