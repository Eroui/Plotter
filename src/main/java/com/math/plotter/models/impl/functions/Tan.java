package com.math.plotter.models.impl.functions;

import com.math.plotter.models.Expression;
import com.math.plotter.models.UnaryExpression;

public class Tan extends UnaryExpression {

    public Tan(Expression argument) {
        super(argument);
    }

    @Override
    public double value(double x) {
        return Math.tan(this.argument.value(x));
    }
}
