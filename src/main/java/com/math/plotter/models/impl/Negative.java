package com.math.plotter.models.impl;

import com.math.plotter.models.Expression;
import com.math.plotter.models.UnaryExpression;

public class Negative extends UnaryExpression {

    public Negative(Expression argument) {
        super(argument);
    }

    @Override
    public double value(double x) {
        return -1.0 * this.argument.value(x);
    }
}
