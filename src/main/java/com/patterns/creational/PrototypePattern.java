package com.patterns.creational;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Prototype Pattern - Specifies the kinds of objects to create using
 * a prototypical instance, and creates new objects by copying this prototype.
 */
public final class PrototypePattern implements Demonstrable {
    
    // Prototype interface
    private interface Shape extends Cloneable {
        Shape clone();
        void draw();
        String getDetails();
    }
    
    // Concrete Prototype
    private static final class Circle implements Shape {
        private final int radius;
        private final String color;
        
        public Circle(int radius, String color) {
            this.radius = radius;
            this.color = color;
        }
        
        @Override
        public Circle clone() {
            return new Circle(this.radius, this.color);
        }
        
        @Override
        public void draw() {
            Logger.log("Drawing circle: " + getDetails());
        }
        
        @Override
        public String getDetails() {
            return String.format("Circle[radius=%d, color=%s]", radius, color);
        }
    }
    
    // Concrete Prototype
    private static final class Rectangle implements Shape {
        private final int width;
        private final int height;
        private final String color;
        
        public Rectangle(int width, int height, String color) {
            this.width = width;
            this.height = height;
            this.color = color;
        }
        
        @Override
        public Rectangle clone() {
            return new Rectangle(this.width, this.height, this.color);
        }
        
        @Override
        public void draw() {
            Logger.log("Drawing rectangle: " + getDetails());
        }
        
        @Override
        public String getDetails() {
            return String.format("Rectangle[width=%d, height=%d, color=%s]", 
                width, height, color);
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Prototype Pattern");
        
        Logger.logSection("Original Shapes");
        Shape originalCircle = new Circle(10, "Red");
        originalCircle.draw();
        
        Shape originalRectangle = new Rectangle(20, 30, "Blue");
        originalRectangle.draw();
        
        Logger.logSection("Cloned Shapes");
        Shape clonedCircle = originalCircle.clone();
        clonedCircle.draw();
        Logger.log("Same instance? " + (originalCircle == clonedCircle));
        
        Shape clonedRectangle = originalRectangle.clone();
        clonedRectangle.draw();
        Logger.log("Same instance? " + (originalRectangle == clonedRectangle));
    }
}
