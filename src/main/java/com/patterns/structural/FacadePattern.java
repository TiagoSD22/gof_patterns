package com.patterns.structural;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Facade Pattern - Provides a unified interface to a set of interfaces
 * in a subsystem.
 */
public final class FacadePattern implements Demonstrable {
    
    // Subsystem classes
    private static final class CPU {
        public void freeze() {
            Logger.log("CPU: Freezing...");
        }
        
        public void jump(long position) {
            Logger.log("CPU: Jumping to position " + position);
        }
        
        public void execute() {
            Logger.log("CPU: Executing...");
        }
    }
    
    private static final class Memory {
        public void load(long position, byte[] data) {
            Logger.log("Memory: Loading data at position " + position);
        }
    }
    
    private static final class HardDrive {
        public byte[] read(long lba, int size) {
            Logger.log("HardDrive: Reading " + size + " bytes from sector " + lba);
            return new byte[size];
        }
    }
    
    // Facade
    private static final class ComputerFacade {
        private final CPU cpu;
        private final Memory memory;
        private final HardDrive hardDrive;
        
        public ComputerFacade() {
            this.cpu = new CPU();
            this.memory = new Memory();
            this.hardDrive = new HardDrive();
        }
        
        public void start() {
            Logger.log("Computer: Starting...");
            cpu.freeze();
            memory.load(0, hardDrive.read(0, 1024));
            cpu.jump(0);
            cpu.execute();
            Logger.log("Computer: Started successfully!");
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Facade Pattern");
        
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
