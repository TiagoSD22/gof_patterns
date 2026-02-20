package com.patterns.creational;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Builder Pattern - Separates the construction of a complex object
 * from its representation.
 */
public final class BuilderPattern implements Demonstrable {
    
    // Product
    private static final class Computer {
        private final String cpu;
        private final String ram;
        private final String storage;
        private final String gpu;
        private final boolean hasWifi;
        
        private Computer(Builder builder) {
            this.cpu = builder.cpu;
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.gpu = builder.gpu;
            this.hasWifi = builder.hasWifi;
        }
        
        @Override
        public String toString() {
            return String.format("Computer[CPU=%s, RAM=%s, Storage=%s, GPU=%s, WiFi=%s]",
                cpu, ram, storage, gpu, hasWifi);
        }
        
        // Builder
        public static final class Builder {
            private final String cpu;
            private final String ram;
            private String storage = "256GB SSD";
            private String gpu = "Integrated";
            private boolean hasWifi = true;
            
            public Builder(String cpu, String ram) {
                this.cpu = cpu;
                this.ram = ram;
            }
            
            public Builder storage(String storage) {
                this.storage = storage;
                return this;
            }
            
            public Builder gpu(String gpu) {
                this.gpu = gpu;
                return this;
            }
            
            public Builder hasWifi(boolean hasWifi) {
                this.hasWifi = hasWifi;
                return this;
            }
            
            public Computer build() {
                return new Computer(this);
            }
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Builder Pattern");
        
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
            .build();
        Logger.log("Basic: " + basicComputer);
        
        Computer gamingComputer = new Computer.Builder("AMD Ryzen 9", "32GB")
            .storage("2TB NVMe")
            .gpu("NVIDIA RTX 4090")
            .hasWifi(true)
            .build();
        Logger.log("Gaming: " + gamingComputer);
    }
}
