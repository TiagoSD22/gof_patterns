package com.patterns.behavioral;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Interpreter Pattern - Given a language, defines a representation for its
 * grammar along with an interpreter that uses the representation to interpret
 * sentences in the language.
 */
public final class InterpreterPattern implements Demonstrable {
    
    // Context
    private static final class Context {
        private final Map<String, Integer> variables = new HashMap<>();
        
        public void setVariable(String name, int value) {
            variables.put(name, value);
        }
        
        public int getVariable(String name) {
            return variables.getOrDefault(name, 0);
        }
    }
    
    // Abstract Expression
    private interface Expression {
        int interpret(Context context);
    }
    
    // Terminal Expression
    private static final class NumberExpression implements Expression {
        private final int number;
        
        public NumberExpression(int number) {
            this.number = number;
        }
        
        @Override
        public int interpret(Context context) {
            return number;
        }
    }
    
    private static final class VariableExpression implements Expression {
        private final String name;
        
        public VariableExpression(String name) {
            this.name = name;
        }
        
        @Override
        public int interpret(Context context) {
            return context.getVariable(name);
        }
    }
    
    // Non-terminal Expressions
    private static final class AddExpression implements Expression {
        private final Expression left;
        private final Expression right;
        
        public AddExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }
        
        @Override
        public int interpret(Context context) {
            return left.interpret(context) + right.interpret(context);
        }
    }
    
    private static final class SubtractExpression implements Expression {
        private final Expression left;
        private final Expression right;
        
        public SubtractExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }
        
        @Override
        public int interpret(Context context) {
            return left.interpret(context) - right.interpret(context);
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Interpreter Pattern");
        
        Context context = new Context();
        context.setVariable("x", 10);
        context.setVariable("y", 5);
        
        // Expression: x + y
        Expression addExpr = new AddExpression(
            new VariableExpression("x"),
            new VariableExpression("y")
        );
        
        // Expression: x - y
        Expression subExpr = new SubtractExpression(
            new VariableExpression("x"),
            new VariableExpression("y")
        );
        
        // Expression: (x + y) + 20
        Expression complexExpr = new AddExpression(
            addExpr,
            new NumberExpression(20)
        );
        
        Logger.log("x = " + context.getVariable("x"));
        Logger.log("y = " + context.getVariable("y"));
        Logger.log("x + y = " + addExpr.interpret(context));
        Logger.log("x - y = " + subExpr.interpret(context));
        Logger.log("(x + y) + 20 = " + complexExpr.interpret(context));
    }
}
