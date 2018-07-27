package com.math.plotter.models;

public abstract class UnaryExpression implements Expression {

    protected Expression argument;

    public UnaryExpression(Expression argument) {
        this.argument = argument;
    }

}
