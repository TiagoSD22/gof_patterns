package com.patterns.creational;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Singleton Pattern - Ensures a class has only one instance
 * and provides a global point of access to it.
 */
public final class SingletonPattern implements Demonstrable {
    
    // Enum-based singleton (thread-safe and prevents serialization/reflection attacks)
    private enum DatabaseConnection {
        INSTANCE;
        
        private final String connectionId;
        
        DatabaseConnection() {
            this.connectionId = "DB-" + System.currentTimeMillis();
        }
        
        public String getConnectionId() {
            return connectionId;
        }
        
        public void connect() {
            Logger.log("Connected with ID: " + connectionId);
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Singleton Pattern");
        
        DatabaseConnection conn1 = DatabaseConnection.INSTANCE;
        DatabaseConnection conn2 = DatabaseConnection.INSTANCE;
        
        conn1.connect();
        Logger.log("Connection 1 ID: " + conn1.getConnectionId());
        Logger.log("Connection 2 ID: " + conn2.getConnectionId());
        Logger.log("Same instance? " + (conn1 == conn2));
    }
}
