package com.math.plotter.models.impl.functions;

import com.math.plotter.models.Expression;
import com.math.plotter.models.UnaryExpression;

public class Cos extends UnaryExpression {

    public Cos(Expression argument) {
        super(argument);
    }

    @Override
    public double value(double x) {
        return Math.cos(this.argument.value(x));
    }
}
