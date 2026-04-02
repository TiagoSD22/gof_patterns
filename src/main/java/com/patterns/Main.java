package com.patterns;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;
import com.patterns.creational.*;
import com.patterns.structural.*;
import com.patterns.behavioral.*;

/**
 * Main class to demonstrate all 23 Gang of Four design patterns.
 * 
 * Design Patterns are categorized into three types:
 * - Creational: Deal with object creation mechanisms
 * - Structural: Deal with object composition
 * - Behavioral: Deal with object collaboration and responsibilities
 * 
 * @author GoF Patterns POC
 * @version 1.0
 */
public final class Main {
    
    private Main() {
        throw new UnsupportedOperationException("Main class cannot be instantiated");
    }
    
    public static void main(String[] args) {
        displayWelcome();
        
        demonstrateCreationalPatterns();
        demonstrateStructuralPatterns();
        demonstrateBehavioralPatterns();
        
        displayConclusion();
    }
    
    private static void displayWelcome() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("  GANG OF FOUR (GoF) DESIGN PATTERNS - COMPREHENSIVE DEMONSTRATION");
        System.out.println("  Java 24 Implementation - Object-Oriented Principles");
        System.out.println("=".repeat(70));
    }
    
    private static void demonstrateCreationalPatterns() {
        displayCategory("CREATIONAL PATTERNS", 
            "Patterns that deal with object creation mechanisms");
        
        executePattern(new SingletonPattern());
        executePattern(new FactoryMethodPattern());
        executePattern(new AbstractFactoryPattern());
        executePattern(new BuilderPattern());
        executePattern(new PrototypePattern());
    }
    
    private static void demonstrateStructuralPatterns() {
        displayCategory("STRUCTURAL PATTERNS", 
            "Patterns that deal with object composition and relationships");
        
        executePattern(new AdapterPattern());
        executePattern(new BridgePattern());
        executePattern(new CompositePattern());
        executePattern(new DecoratorPattern());
        executePattern(new FacadePattern());
        executePattern(new FlyweightPattern());
        executePattern(new ProxyPattern());
    }
    
    private static void demonstrateBehavioralPatterns() {
        displayCategory("BEHAVIORAL PATTERNS", 
            "Patterns that deal with object collaboration and responsibilities");
        
        executePattern(new ChainOfResponsibilityPattern());
        executePattern(new CommandPattern());
        executePattern(new InterpreterPattern());
        executePattern(new IteratorPattern());
        executePattern(new MediatorPattern());
        executePattern(new MementoPattern());
        executePattern(new ObserverPattern());
        executePattern(new StatePattern());
        executePattern(new StrategyPattern());
        executePattern(new TemplateMethodPattern());
        executePattern(new VisitorPattern());
    }
    
    private static void executePattern(Demonstrable pattern) {
        try {
            pattern.demonstrate();
        } catch (Exception e) {
            Logger.log("Error demonstrating pattern: " + e.getMessage());
        }
    }
    
    private static void displayCategory(String title, String description) {
        System.out.println("\n\n" + "█".repeat(70));
        System.out.println("█  " + title);
        System.out.println("█  " + description);
        System.out.println("█".repeat(70));
    }
    
    private static void displayConclusion() {
        System.out.println("\n\n" + "=".repeat(70));
        System.out.println("  DEMONSTRATION COMPLETE");
        System.out.println("  All 23 Gang of Four design patterns successfully demonstrated!");
        System.out.println("  ");
        System.out.println("  Pattern Summary:");
        System.out.println("  - Creational Patterns: 5");
        System.out.println("  - Structural Patterns: 7");
        System.out.println("  - Behavioral Patterns: 11");
        System.out.println("  - Total: 23 patterns");
        System.out.println("=".repeat(70) + "\n");
    }
}
