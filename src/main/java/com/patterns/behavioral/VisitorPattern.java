package com.patterns.behavioral;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * Visitor Pattern - Represents an operation to be performed on elements
 * of an object structure.
 */
public final class VisitorPattern implements Demonstrable {
    
    // Visitor interface
    private interface ShapeVisitor {
        void visit(Circle circle);
        void visit(Rectangle rectangle);
    }
    
    // Element interface
    private interface Shape {
        void accept(ShapeVisitor visitor);
    }
    
    // Concrete Elements
    private static final class Circle implements Shape {
        private final double radius;
        
        public Circle(double radius) {
            this.radius = radius;
        }
        
        public double getRadius() {
            return radius;
        }
        
        @Override
        public void accept(ShapeVisitor visitor) {
            visitor.visit(this);
        }
    }
    
    private static final class Rectangle implements Shape {
        private final double width;
        private final double height;
        
        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }
        
        public double getWidth() {
            return width;
        }
        
        public double getHeight() {
            return height;
        }
        
        @Override
        public void accept(ShapeVisitor visitor) {
            visitor.visit(this);
        }
    }
    
    // Concrete Visitors
    private static final class AreaCalculator implements ShapeVisitor {
        @Override
        public void visit(Circle circle) {
            double area = Math.PI * circle.getRadius() * circle.getRadius();
            Logger.log("Circle area: " + String.format("%.2f", area));
        }
        
        @Override
        public void visit(Rectangle rectangle) {
            double area = rectangle.getWidth() * rectangle.getHeight();
            Logger.log("Rectangle area: " + String.format("%.2f", area));
        }
    }
    
    private static final class PerimeterCalculator implements ShapeVisitor {
        @Override
        public void visit(Circle circle) {
            double perimeter = 2 * Math.PI * circle.getRadius();
            Logger.log("Circle perimeter: " + String.format("%.2f", perimeter));
        }
        
        @Override
        public void visit(Rectangle rectangle) {
            double perimeter = 2 * (rectangle.getWidth() + rectangle.getHeight());
            Logger.log("Rectangle perimeter: " + String.format("%.2f", perimeter));
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Visitor Pattern");
        
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(5.0));
        shapes.add(new Rectangle(4.0, 6.0));
        
        ShapeVisitor areaCalculator = new AreaCalculator();
        ShapeVisitor perimeterCalculator = new PerimeterCalculator();
        
        Logger.logSection("Calculating Areas");
        for (Shape shape : shapes) {
            shape.accept(areaCalculator);
        }
        
        Logger.logSection("Calculating Perimeters");
        for (Shape shape : shapes) {
            shape.accept(perimeterCalculator);
        }
    }
}
