package com.math.plotter.models.impl.functions;

import com.math.plotter.models.Expression;
import com.math.plotter.models.UnaryExpression;

public class Sin extends UnaryExpression {

    public Sin() {
        super();
    }

    public Sin(Expression argument) {
        super(argument);
    }

    @Override
    public double value(double x) {
        return Math.sin(this.argument.value(x));
    }
}
