package com.math.plotter.compile;

import com.math.plotter.models.Expression;
import com.math.plotter.models.impl.*;
import com.math.plotter.models.impl.functions.Cos;
import com.math.plotter.models.impl.functions.Sin;
import com.math.plotter.models.impl.functions.Tan;
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

    @Test
    public void AdditionAnalyserTest() throws Exception {
        double value = r.nextDouble();
        Analyser analyser = new Analyser("x+x");

        Expression addition_actual = analyser.analyse();
        Expression addition_expected = new Addition(
                new Variable(),
                new Variable()
        );

        assertEquals("Failed Analyser Addition Test",
                addition_actual.value(value),
                addition_expected.value(value),
                error);
    }

    @Test
    public void SubstructionAnalyserTest() throws Exception {
        double value = r.nextDouble();
        Analyser analyser = new Analyser("x-0.5");

        Expression substruction_actual = analyser.analyse();
        Expression substruction_expected = new Substruction(
                new Variable(),
                new Constant(0.5)
        );

        assertEquals("Failed Substruction Analyser Test",
                substruction_actual.value(value),
                substruction_expected.value(value),
                error);
    }

    @Test
    public void DivisionAnalyserTest() throws Exception {
        double value = r.nextDouble();
        Analyser analyser = new Analyser("1/x");

        Expression division_actual = analyser.analyse();
        Expression division_expected = new Division(
                new Constant(1),
                new Variable()
        );

        assertEquals("Failed Division Analyser Test",
                division_actual.value(value),
                division_expected.value(value),
                error);
    }

    @Test
    public void negativeAnalyserTest() throws Exception {
        double value = r.nextDouble();
        Analyser analyser = new Analyser("-x");

        Expression negative_actual = analyser.analyse();
        Expression negative_expected = new Negative(new Variable());

        assertEquals("Failed Negative Analyser Test",
                negative_actual.value(value),
                negative_expected.value(value),
                error);
    }

    @Test
    public void CosAnalyserTest() throws Exception {
        double value = r.nextDouble();
        Analyser analyser = new Analyser("cos(x)*x");

        Expression cos_actual = analyser.analyse();
        Expression cos_expected = new Multiplication(
                new Cos(new Variable()),
                new Variable()
        );

        assertEquals("Failed Cos Analyser Test",
                cos_actual.value(value),
                cos_expected.value(value),
                error);
    }

    @Test
    public void SinAnalyserTest() throws Exception {
        double value = r.nextDouble();
        Analyser analyser = new Analyser("sin(x)*x");

        Expression sin_actual = analyser.analyse();
        Expression sin_expected = new Multiplication(
                new Sin(new Variable()),
                new Variable()
        );

        assertEquals("Failed Sin Analyser Test",
                sin_actual.value(value),
                sin_expected.value(value),
                error);
    }

    @Test
    public void TanAnalyserTest() throws Exception {
        double value = r.nextDouble();
        Analyser analyser = new Analyser("tan(x)*x");

        Expression tan_actual = analyser.analyse();
        Expression tan_expected = new Multiplication(
                new Tan(new Variable()),
                new Variable()
        );

        assertEquals("failed Tan Analyser Test",
                tan_actual.value(value),
                tan_expected.value(value),
                error);
    }

}