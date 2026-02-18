package com.patterns.structural;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Decorator Pattern - Attaches additional responsibilities to an object
 * dynamically.
 */
public final class DecoratorPattern implements Demonstrable {
    
    // Component
    private interface Coffee {
        String getDescription();
        double getCost();
    }
    
    // Concrete Component
    private static final class SimpleCoffee implements Coffee {
        @Override
        public String getDescription() {
            return "Simple Coffee";
        }
        
        @Override
        public double getCost() {
            return 2.00;
        }
    }
    
    // Decorator
    private abstract static class CoffeeDecorator implements Coffee {
        protected final Coffee decoratedCoffee;
        
        protected CoffeeDecorator(Coffee coffee) {
            this.decoratedCoffee = coffee;
        }
        
        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription();
        }
        
        @Override
        public double getCost() {
            return decoratedCoffee.getCost();
        }
    }
    
    // Concrete Decorators
    private static final class MilkDecorator extends CoffeeDecorator {
        public MilkDecorator(Coffee coffee) {
            super(coffee);
        }
        
        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription() + ", Milk";
        }
        
        @Override
        public double getCost() {
            return decoratedCoffee.getCost() + 0.50;
        }
    }
    
    private static final class SugarDecorator extends CoffeeDecorator {
        public SugarDecorator(Coffee coffee) {
            super(coffee);
        }
        
        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription() + ", Sugar";
        }
        
        @Override
        public double getCost() {
            return decoratedCoffee.getCost() + 0.20;
        }
    }
    
    private static final class WhipDecorator extends CoffeeDecorator {
        public WhipDecorator(Coffee coffee) {
            super(coffee);
        }
        
        @Override
        public String getDescription() {
            return decoratedCoffee.getDescription() + ", Whipped Cream";
        }
        
        @Override
        public double getCost() {
            return decoratedCoffee.getCost() + 0.75;
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Decorator Pattern");
        
        Coffee coffee = new SimpleCoffee();
        Logger.log(coffee.getDescription() + " - $" + coffee.getCost());
        
        coffee = new MilkDecorator(coffee);
        Logger.log(coffee.getDescription() + " - $" + coffee.getCost());
        
        coffee = new SugarDecorator(coffee);
        Logger.log(coffee.getDescription() + " - $" + coffee.getCost());
        
        coffee = new WhipDecorator(coffee);
        Logger.log(coffee.getDescription() + " - $" + coffee.getCost());
    }
}
