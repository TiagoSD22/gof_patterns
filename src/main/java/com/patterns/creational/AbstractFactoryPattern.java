package com.patterns.creational;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Abstract Factory Pattern - Provides an interface for creating families
 * of related or dependent objects without specifying their concrete classes.
 */
public final class AbstractFactoryPattern implements Demonstrable {
    
    // Abstract Products
    private interface Button {
        void render();
    }
    
    private interface Checkbox {
        void render();
    }
    
    // Concrete Products - Windows
    private static final class WindowsButton implements Button {
        @Override
        public void render() {
            Logger.log("Rendering Windows-style button");
        }
    }
    
    private static final class WindowsCheckbox implements Checkbox {
        @Override
        public void render() {
            Logger.log("Rendering Windows-style checkbox");
        }
    }
    
    // Concrete Products - Mac
    private static final class MacButton implements Button {
        @Override
        public void render() {
            Logger.log("Rendering Mac-style button");
        }
    }
    
    private static final class MacCheckbox implements Checkbox {
        @Override
        public void render() {
            Logger.log("Rendering Mac-style checkbox");
        }
    }
    
    // Abstract Factory
    private interface GUIFactory {
        Button createButton();
        Checkbox createCheckbox();
    }
    
    // Concrete Factories
    private static final class WindowsFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new WindowsButton();
        }
        
        @Override
        public Checkbox createCheckbox() {
            return new WindowsCheckbox();
        }
    }
    
    private static final class MacFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new MacButton();
        }
        
        @Override
        public Checkbox createCheckbox() {
            return new MacCheckbox();
        }
    }
    
    // Client
    private static final class Application {
        private final Button button;
        private final Checkbox checkbox;
        
        public Application(GUIFactory factory) {
            this.button = factory.createButton();
            this.checkbox = factory.createCheckbox();
        }
        
        public void render() {
            button.render();
            checkbox.render();
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Abstract Factory Pattern");
        
        Logger.logSection("Windows UI");
        Application windowsApp = new Application(new WindowsFactory());
        windowsApp.render();
        
        Logger.logSection("Mac UI");
        Application macApp = new Application(new MacFactory());
        macApp.render();
    }
}
