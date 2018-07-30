package com.math.plotter.models.impl.functions;

import com.math.plotter.models.Expression;
import com.math.plotter.models.impl.Constant;
import com.math.plotter.models.impl.Variable;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class TanTest {

    private final Random r = new Random();
    private final double error = 1e-9;

    @Test
    public void tanOfConstantTest() {
        double value = r.nextDouble();
        Expression tan = new Tan(new Constant(value));

        assertEquals("Failed Tan of constant test",
                tan.value(r.nextDouble()),
                Math.tan(value),
                error);
    }

    @Test
    public void tanOfVariableTest() {
        double value = r.nextDouble();
        Expression tan = new Tan(new Variable());

        assertEquals("Failed Tan of Variable Test",
                tan.value(value),
                Math.tan(value),
                error);
    }
}