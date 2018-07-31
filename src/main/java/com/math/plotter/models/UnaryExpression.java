package com.math.plotter.models;

public abstract class UnaryExpression implements Expression {

    protected Expression argument;

    public UnaryExpression() {}
    public UnaryExpression(Expression argument) {
        this();
        this.argument = argument;
    }

    // TODO potential null pointer exception bug must be handled (think of an optional)
    public void setArgument(Expression argument) {
        this.argument = argument;
    }

}
