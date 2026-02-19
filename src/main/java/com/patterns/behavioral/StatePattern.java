package com.patterns.behavioral;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * State Pattern - Allows an object to alter its behavior when its
 * internal state changes.
 */
public final class StatePattern implements Demonstrable {
    
    // State interface
    private interface State {
        void insertCoin(VendingMachine machine);
        void pressButton(VendingMachine machine);
        void dispense(VendingMachine machine);
    }
    
    // Concrete States
    private static final class NoCoinState implements State {
        @Override
        public void insertCoin(VendingMachine machine) {
            Logger.log("Coin inserted");
            machine.setState(machine.getHasCoinState());
        }
        
        @Override
        public void pressButton(VendingMachine machine) {
            Logger.log("Insert coin first");
        }
        
        @Override
        public void dispense(VendingMachine machine) {
            Logger.log("Payment required");
        }
    }
    
    private static final class HasCoinState implements State {
        @Override
        public void insertCoin(VendingMachine machine) {
            Logger.log("Coin already inserted");
        }
        
        @Override
        public void pressButton(VendingMachine machine) {
            Logger.log("Button pressed, dispensing product...");
            machine.setState(machine.getDispenseState());
        }
        
        @Override
        public void dispense(VendingMachine machine) {
            Logger.log("Press button first");
        }
    }
    
    private static final class DispenseState implements State {
        @Override
        public void insertCoin(VendingMachine machine) {
            Logger.log("Please wait, dispensing product");
        }
        
        @Override
        public void pressButton(VendingMachine machine) {
            Logger.log("Already dispensing");
        }
        
        @Override
        public void dispense(VendingMachine machine) {
            Logger.log("Product dispensed!");
            machine.setState(machine.getNoCoinState());
        }
    }
    
    // Context
    private static final class VendingMachine {
        private final State noCoinState;
        private final State hasCoinState;
        private final State dispenseState;
        private State currentState;
        
        public VendingMachine() {
            this.noCoinState = new NoCoinState();
            this.hasCoinState = new HasCoinState();
            this.dispenseState = new DispenseState();
            this.currentState = noCoinState;
        }
        
        public void insertCoin() {
            currentState.insertCoin(this);
        }
        
        public void pressButton() {
            currentState.pressButton(this);
            currentState.dispense(this);
        }
        
        public void setState(State state) {
            this.currentState = state;
        }
        
        public State getNoCoinState() { return noCoinState; }
        public State getHasCoinState() { return hasCoinState; }
        public State getDispenseState() { return dispenseState; }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("State Pattern");
        
        VendingMachine machine = new VendingMachine();
        
        Logger.logSection("Attempting to buy without coin");
        machine.pressButton();
        
        Logger.logSection("Inserting coin and buying");
        machine.insertCoin();
        machine.pressButton();
        
        Logger.logSection("Buying again");
        machine.insertCoin();
        machine.pressButton();
    }
}
