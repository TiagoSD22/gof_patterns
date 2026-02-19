package com.patterns.behavioral;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * Mediator Pattern - Defines an object that encapsulates how a set of
 * objects interact.
 */
public final class MediatorPattern implements Demonstrable {
    
    // Mediator interface
    private interface ChatMediator {
        void sendMessage(String message, User user);
        void addUser(User user);
    }
    
    // Concrete Mediator
    private static final class ChatRoom implements ChatMediator {
        private final List<User> users = new ArrayList<>();
        
        @Override
        public void addUser(User user) {
            users.add(user);
        }
        
        @Override
        public void sendMessage(String message, User sender) {
            for (User user : users) {
                if (user != sender) {
                    user.receive(message);
                }
            }
        }
    }
    
    // Colleague
    private abstract static class User {
        protected ChatMediator mediator;
        protected String name;
        
        public User(ChatMediator mediator, String name) {
            this.mediator = mediator;
            this.name = name;
        }
        
        public abstract void send(String message);
        public abstract void receive(String message);
    }
    
    // Concrete Colleague
    private static final class ChatUser extends User {
        public ChatUser(ChatMediator mediator, String name) {
            super(mediator, name);
        }
        
        @Override
        public void send(String message) {
            Logger.log(name + " sends: " + message);
            mediator.sendMessage(message, this);
        }
        
        @Override
        public void receive(String message) {
            Logger.log(name + " receives: " + message);
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Mediator Pattern");
        
        ChatMediator chatRoom = new ChatRoom();
        
        User alice = new ChatUser(chatRoom, "Alice");
        User bob = new ChatUser(chatRoom, "Bob");
        User charlie = new ChatUser(chatRoom, "Charlie");
        
        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(charlie);
        
        Logger.logSection("Alice sends a message");
        alice.send("Hello everyone!");
        
        Logger.logSection("Bob sends a message");
        bob.send("Hi Alice!");
    }
}
