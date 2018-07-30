package com.math.plotter.models.impl;

import com.math.plotter.models.Expression;

public class Variable implements Expression {

    public Variable() {
        // Default Constructor
    }

    @Override
    public double value(double x) {
        return x;
    }
}
