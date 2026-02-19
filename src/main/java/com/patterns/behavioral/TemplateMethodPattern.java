package com.patterns.behavioral;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Template Method Pattern - Defines the skeleton of an algorithm in a method,
 * deferring some steps to subclasses.
 */
public final class TemplateMethodPattern implements Demonstrable {
    
    // Abstract Class with template method
    private abstract static class DataProcessor {
        
        // Template method
        public final void process() {
            readData();
            processData();
            writeData();
        }
        
        protected abstract void readData();
        protected abstract void processData();
        protected abstract void writeData();
    }
    
    // Concrete Classes
    private static final class CSVDataProcessor extends DataProcessor {
        @Override
        protected void readData() {
            Logger.log("Reading data from CSV file");
        }
        
        @Override
        protected void processData() {
            Logger.log("Processing CSV data");
        }
        
        @Override
        protected void writeData() {
            Logger.log("Writing processed data to CSV file");
        }
    }
    
    private static final class JSONDataProcessor extends DataProcessor {
        @Override
        protected void readData() {
            Logger.log("Reading data from JSON file");
        }
        
        @Override
        protected void processData() {
            Logger.log("Processing JSON data");
        }
        
        @Override
        protected void writeData() {
            Logger.log("Writing processed data to JSON file");
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Template Method Pattern");
        
        Logger.logSection("Processing CSV Data");
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.process();
        
        Logger.logSection("Processing JSON Data");
        DataProcessor jsonProcessor = new JSONDataProcessor();
        jsonProcessor.process();
    }
}
