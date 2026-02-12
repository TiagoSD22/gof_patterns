package com.patterns.behavioral;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Chain of Responsibility Pattern - Avoids coupling the sender of a request
 * to its receiver by giving more than one object a chance to handle the request.
 */
public final class ChainOfResponsibilityPattern implements Demonstrable {
    
    // Handler
    private abstract static class SupportHandler {
        protected SupportHandler nextHandler;
        
        public void setNext(SupportHandler handler) {
            this.nextHandler = handler;
        }
        
        public abstract void handleRequest(String issue, int priority);
    }
    
    // Concrete Handlers
    private static final class Level1Support extends SupportHandler {
        @Override
        public void handleRequest(String issue, int priority) {
            if (priority <= 1) {
                Logger.log("Level 1 Support: Handling issue - " + issue);
            } else if (nextHandler != null) {
                Logger.log("Level 1 Support: Escalating to Level 2");
                nextHandler.handleRequest(issue, priority);
            }
        }
    }
    
    private static final class Level2Support extends SupportHandler {
        @Override
        public void handleRequest(String issue, int priority) {
            if (priority <= 2) {
                Logger.log("Level 2 Support: Handling issue - " + issue);
            } else if (nextHandler != null) {
                Logger.log("Level 2 Support: Escalating to Level 3");
                nextHandler.handleRequest(issue, priority);
            }
        }
    }
    
    private static final class Level3Support extends SupportHandler {
        @Override
        public void handleRequest(String issue, int priority) {
            Logger.log("Level 3 Support: Handling critical issue - " + issue);
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Chain of Responsibility Pattern");
        
        SupportHandler level1 = new Level1Support();
        SupportHandler level2 = new Level2Support();
        SupportHandler level3 = new Level3Support();
        
        level1.setNext(level2);
        level2.setNext(level3);
        
        Logger.logSection("Low Priority Issue");
        level1.handleRequest("Password reset", 1);
        
        Logger.logSection("Medium Priority Issue");
        level1.handleRequest("Software bug", 2);
        
        Logger.logSection("High Priority Issue");
        level1.handleRequest("System down", 3);
    }
}
