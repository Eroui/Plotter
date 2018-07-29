package com.math.plotter.models.impl;

import com.math.plotter.models.BinaryExpression;
import com.math.plotter.models.Expression;

public class Division extends BinaryExpression {

    public Division(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double value(double x) {
        // TODO handle division by 0
        return left.value(x) / right.value(x);
    }
}
