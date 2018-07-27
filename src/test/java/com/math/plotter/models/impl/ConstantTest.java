package com.math.plotter.models.impl;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class ConstantTest {

    @Test
    public void value() {
        Random r = new Random();
        double value = r.nextDouble();
        Constant cte = new Constant(value);

        assertEquals("Constant Test is not correct ", cte.value(r.nextDouble()), value, 1e-9);
        assertEquals("Constant Test is not correct ", cte.value(r.nextDouble()), value, 1e-9);
        assertEquals("Constant Test is not correct ", cte.value(r.nextDouble()), value, 1e-9);
        assertEquals("Constant Test is not correct ", cte.value(r.nextDouble()), value, 1e-9);
        assertEquals("Constant Test is not correct ", cte.value(r.nextDouble()), value, 1e-9);
    }
}