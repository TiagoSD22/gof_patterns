package com.patterns.structural;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Bridge Pattern - Decouples an abstraction from its implementation
 * so that the two can vary independently.
 */
public final class BridgePattern implements Demonstrable {
    
    // Implementation interface
    private interface Color {
        void applyColor();
    }
    
    // Concrete Implementations
    private static final class RedColor implements Color {
        @Override
        public void applyColor() {
            Logger.log("Applying red color");
        }
    }
    
    private static final class BlueColor implements Color {
        @Override
        public void applyColor() {
            Logger.log("Applying blue color");
        }
    }
    
    // Abstraction
    private abstract static class Shape {
        protected final Color color;
        
        protected Shape(Color color) {
            this.color = color;
        }
        
        public abstract void draw();
    }
    
    // Refined Abstractions
    private static final class Circle extends Shape {
        public Circle(Color color) {
            super(color);
        }
        
        @Override
        public void draw() {
            Logger.log("Drawing Circle");
            color.applyColor();
        }
    }
    
    private static final class Square extends Shape {
        public Square(Color color) {
            super(color);
        }
        
        @Override
        public void draw() {
            Logger.log("Drawing Square");
            color.applyColor();
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Bridge Pattern");
        
        Shape redCircle = new Circle(new RedColor());
        Shape blueSquare = new Square(new BlueColor());
        
        Logger.logSection("Red Circle");
        redCircle.draw();
        
        Logger.logSection("Blue Square");
        blueSquare.draw();
    }
}
