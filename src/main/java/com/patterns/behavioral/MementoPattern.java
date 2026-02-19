package com.patterns.behavioral;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Memento Pattern - Captures and externalizes an object's internal state
 * without violating encapsulation.
 */
public final class MementoPattern implements Demonstrable {
    
    // Memento
    private static final class TextMemento {
        private final String state;
        
        private TextMemento(String state) {
            this.state = state;
        }
        
        private String getState() {
            return state;
        }
    }
    
    // Originator
    private static final class TextEditor {
        private String text = "";
        
        public void write(String newText) {
            this.text += newText;
            Logger.log("Current text: " + text);
        }
        
        public TextMemento save() {
            Logger.log("Saving state: " + text);
            return new TextMemento(text);
        }
        
        public void restore(TextMemento memento) {
            this.text = memento.getState();
            Logger.log("Restored text: " + text);
        }
        
        public String getText() {
            return text;
        }
    }
    
    // Caretaker
    private static final class History {
        private TextMemento memento;
        
        public void save(TextMemento memento) {
            this.memento = memento;
        }
        
        public TextMemento undo() {
            return memento;
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Memento Pattern");
        
        TextEditor editor = new TextEditor();
        History history = new History();
        
        Logger.logSection("Writing text");
        editor.write("Hello ");
        editor.write("World!");
        
        Logger.logSection("Saving state");
        history.save(editor.save());
        
        Logger.logSection("Writing more text");
        editor.write(" This is a test.");
        
        Logger.logSection("Restoring previous state");
        editor.restore(history.undo());
    }
}
