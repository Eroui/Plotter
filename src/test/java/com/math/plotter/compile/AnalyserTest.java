package com.math.plotter.compile;

import com.math.plotter.models.Expression;
import com.math.plotter.models.impl.Constant;
import com.math.plotter.models.impl.Multiplication;
import com.math.plotter.models.impl.Variable;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class AnalyserTest {

    Random r = new Random();
    double error = 1e-9;

    @Test
    public void constantTest() throws Exception {
        double value = r.nextDouble();
        Analyser analyser = new Analyser(Double.toString(value));

        Expression constant_actual = analyser.analyse();
        Expression constant_expected = new Constant(value);

        assertEquals("Failed Analyser Constant Test",
                constant_actual.value(r.nextDouble()),
                constant_expected.value(r.nextDouble()),
                error);
    }

    @Test
    public void VariableAnalyserTest() throws Exception {
        double value = r.nextDouble();
        Analyser analyser = new Analyser("x");

        Expression variable_actual = analyser.analyse();
        Expression variable_expected = new Variable();

        assertEquals("Failed Analyser Variable Test",
                variable_actual.value(value),
                variable_expected.value(value),
                error);
    }

    @Test
    public void MultiplicationAnalyserTest() throws Exception {
        double value = r.nextDouble();
        Analyser analyser = new Analyser("x*x");

        Expression multiplication_actual = analyser.analyse();
        Expression multiplication_expected = new Multiplication(
                new Variable(),
                new Variable()
        );

        assertEquals("Failed Analyser Multiplication Test",
                multiplication_actual.value(value),
                multiplication_expected.value(value),
                error);
    }

}