package com.math.plotter.models.impl;

import com.math.plotter.models.BinaryExpression;
import com.math.plotter.models.Expression;

public class Substruction extends BinaryExpression {

    public Substruction(Expression left, Expression right) {
        super(left, right);
    }

    public double value(double x) {
        return this.left.value(x) - this.right.value(x);
    }
}
