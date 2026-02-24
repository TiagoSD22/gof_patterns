package com.patterns.common;

/**
 * Common logger utility for all pattern demonstrations.
 * Follows Single Responsibility Principle.
 */
public final class Logger {
    
    private static final String SEPARATOR = "=".repeat(60);
    
    private Logger() {
        throw new UnsupportedOperationException("Utility class");
    }
    
    public static void logPattern(String patternName) {
        System.out.println("\n" + SEPARATOR);
        System.out.println("  " + patternName.toUpperCase());
        System.out.println(SEPARATOR);
    }
    
    public static void log(String message) {
        System.out.println("  " + message);
    }
    
    public static void logSection(String section) {
        System.out.println("\n  --- " + section + " ---");
    }
}
