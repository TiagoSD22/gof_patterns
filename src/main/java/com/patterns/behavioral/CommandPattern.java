package com.patterns.behavioral;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Command Pattern - Encapsulates a request as an object, thereby letting
 * you parameterize clients with different requests.
 */
public final class CommandPattern implements Demonstrable {
    
    // Receiver
    private static final class Light {
        private boolean isOn = false;
        
        public void turnOn() {
            isOn = true;
            Logger.log("Light is ON");
        }
        
        public void turnOff() {
            isOn = false;
            Logger.log("Light is OFF");
        }
    }
    
    // Command interface
    private interface Command {
        void execute();
        void undo();
    }
    
    // Concrete Commands
    private static final class TurnOnCommand implements Command {
        private final Light light;
        
        public TurnOnCommand(Light light) {
            this.light = light;
        }
        
        @Override
        public void execute() {
            light.turnOn();
        }
        
        @Override
        public void undo() {
            light.turnOff();
        }
    }
    
    private static final class TurnOffCommand implements Command {
        private final Light light;
        
        public TurnOffCommand(Light light) {
            this.light = light;
        }
        
        @Override
        public void execute() {
            light.turnOff();
        }
        
        @Override
        public void undo() {
            light.turnOn();
        }
    }
    
    // Invoker
    private static final class RemoteControl {
        private Command command;
        
        public void setCommand(Command command) {
            this.command = command;
        }
        
        public void pressButton() {
            if (command != null) {
                command.execute();
            }
        }
        
        public void pressUndo() {
            if (command != null) {
                command.undo();
            }
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Command Pattern");
        
        Light light = new Light();
        Command turnOn = new TurnOnCommand(light);
        Command turnOff = new TurnOffCommand(light);
        
        RemoteControl remote = new RemoteControl();
        
        Logger.logSection("Turn On");
        remote.setCommand(turnOn);
        remote.pressButton();
        
        Logger.logSection("Turn Off");
        remote.setCommand(turnOff);
        remote.pressButton();
        
        Logger.logSection("Undo (Turn On again)");
        remote.pressUndo();
    }
}
