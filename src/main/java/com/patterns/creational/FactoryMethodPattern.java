package com.patterns.creational;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Factory Method Pattern - Defines an interface for creating an object,
 * but lets subclasses decide which class to instantiate.
 */
public final class FactoryMethodPattern implements Demonstrable {
    
    // Product interface
    private interface Document {
        void open();
        void save();
        String getType();
    }
    
    // Concrete Products
    private static final class PdfDocument implements Document {
        @Override
        public void open() {
            Logger.log("Opening PDF document");
        }
        
        @Override
        public void save() {
            Logger.log("Saving PDF document");
        }
        
        @Override
        public String getType() {
            return "PDF";
        }
    }
    
    private static final class WordDocument implements Document {
        @Override
        public void open() {
            Logger.log("Opening Word document");
        }
        
        @Override
        public void save() {
            Logger.log("Saving Word document");
        }
        
        @Override
        public String getType() {
            return "Word";
        }
    }
    
    // Creator (Factory)
    private abstract static class DocumentCreator {
        public abstract Document createDocument();
        
        public void processDocument() {
            Document doc = createDocument();
            doc.open();
            doc.save();
        }
    }
    
    // Concrete Creators
    private static final class PdfCreator extends DocumentCreator {
        @Override
        public Document createDocument() {
            return new PdfDocument();
        }
    }
    
    private static final class WordCreator extends DocumentCreator {
        @Override
        public Document createDocument() {
            return new WordDocument();
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Factory Method Pattern");
        
        DocumentCreator pdfCreator = new PdfCreator();
        Logger.logSection("Creating PDF Document");
        pdfCreator.processDocument();
        
        DocumentCreator wordCreator = new WordCreator();
        Logger.logSection("Creating Word Document");
        wordCreator.processDocument();
    }
}
