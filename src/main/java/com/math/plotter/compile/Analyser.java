package com.math.plotter.compile;

import com.math.plotter.models.Expression;
import com.math.plotter.models.UnaryExpression;
import com.math.plotter.models.impl.*;
import com.math.plotter.models.impl.functions.Cos;
import com.math.plotter.models.impl.functions.Sin;
import com.math.plotter.models.impl.functions.Tan;

import java.io.StreamTokenizer;
import java.io.StringReader;

// TODO implement Tests
// TODO Refactor
// TODO Add comments after refactoring
public class Analyser {

    private StreamTokenizer lexical;

    public Analyser(String function) {
        lexical = new StreamTokenizer(new StringReader(function));
        lexical.ordinaryChar('/');
        lexical.ordinaryChar('-');
    }

    public Expression analyse() throws Exception {
        lexical.nextToken();
        Expression result = this.analyseExpression();
        if(lexical.ttype != StreamTokenizer.TT_EOF)
            throw new Exception("End of of function Expected");

        return result;
    }

    private Expression analyseExpression() throws Exception {

        boolean isNegative = false;
        if (lexical.ttype == '-'){
            isNegative = true;
            lexical.nextToken();
        }

        Expression result = this.analyseTerm();

        if(isNegative) {
            result = new Negative(result);
        }

        while(lexical.ttype == '+' || lexical.ttype == '-') {
            boolean isAddition = lexical.ttype == '+';
            lexical.nextToken();

            Expression term = analyseTerm();

            if(isAddition)
                result = new Addition(result, term);
            else
                result = new Substruction(result, term);
        }

        return result;
    }

    private Expression analyseTerm() throws Exception {
        Expression result = this.analyseFactor();

        while(lexical.ttype == '*' || lexical.ttype == '/') {
            boolean isMultiplication = lexical.ttype == '*';
            lexical.nextToken();
            Expression factor = analyseFactor();
            if(isMultiplication)
                result = new Multiplication(result, factor);
            else
                result = new Division(result, factor);
        }

        return result;
    }

    private Expression analyseFactor() throws Exception {
        Expression result = null;
        if(lexical.ttype == StreamTokenizer.TT_NUMBER) {
            result = new Constant(lexical.nval);
            lexical.nextToken();

        } else if(lexical.ttype == StreamTokenizer.TT_WORD) {
            String token = lexical.sval.toLowerCase();

            if(token.equals("x")) {
                result = new Variable();
                lexical.nextToken();
            } else {

                if(token.equals("sin")) result = new Sin();
                else if(token.equals("cos")) result = new Cos();
                else if(token.equals("tan")) result = new Tan();
                else
                    throw new Exception("Unexpected word " + token);

                lexical.nextToken();
                if(lexical.ttype != '(')
                    throw new Exception("'(' Expected");

                lexical.nextToken();
                ((UnaryExpression) result).setArgument(analyseExpression());

                if (lexical.ttype != ')')
                    throw new Exception(") Expected");
                lexical.nextToken();
            }


        } else if(lexical.ttype == '(') {
            lexical.nextToken();
            result = analyseExpression();

            if(lexical.ttype != ')')
                throw new Exception("Unexpected ')'");
            lexical.nextToken();

        } else {
            throw new Exception("Unexpected symbole '" + (char) lexical.ttype + "'");
        }

        return result;
    }
}
