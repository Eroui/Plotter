package com.math.plotter.models.impl;

import com.math.plotter.models.Expression;

public class Constant implements Expression {

    private double value;

    public Constant(double value) {
        this.value = value;
    }

    public double value(double x) {
        return this.value;
    }
}
