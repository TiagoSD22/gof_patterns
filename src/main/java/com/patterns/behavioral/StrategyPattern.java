package com.patterns.behavioral;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Strategy Pattern - Defines a family of algorithms, encapsulates each one,
 * and makes them interchangeable.
 */
public final class StrategyPattern implements Demonstrable {
    
    // Strategy interface
    private interface PaymentStrategy {
        void pay(double amount);
    }
    
    // Concrete Strategies
    private static final class CreditCardStrategy implements PaymentStrategy {
        private final String cardNumber;
        
        public CreditCardStrategy(String cardNumber) {
            this.cardNumber = cardNumber;
        }
        
        @Override
        public void pay(double amount) {
            Logger.log("Paid $" + amount + " using Credit Card ending in " + 
                      cardNumber.substring(cardNumber.length() - 4));
        }
    }
    
    private static final class PayPalStrategy implements PaymentStrategy {
        private final String email;
        
        public PayPalStrategy(String email) {
            this.email = email;
        }
        
        @Override
        public void pay(double amount) {
            Logger.log("Paid $" + amount + " using PayPal account " + email);
        }
    }
    
    private static final class BitcoinStrategy implements PaymentStrategy {
        private final String walletAddress;
        
        public BitcoinStrategy(String walletAddress) {
            this.walletAddress = walletAddress;
        }
        
        @Override
        public void pay(double amount) {
            Logger.log("Paid $" + amount + " using Bitcoin wallet " + 
                      walletAddress.substring(0, 10) + "...");
        }
    }
    
    // Context
    private static final class ShoppingCart {
        private double total;
        
        public void addItem(double price) {
            total += price;
        }
        
        public void checkout(PaymentStrategy strategy) {
            Logger.log("Total: $" + total);
            strategy.pay(total);
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Strategy Pattern");
        
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(50.00);
        cart.addItem(30.00);
        
        Logger.logSection("Paying with Credit Card");
        cart.checkout(new CreditCardStrategy("1234567890123456"));
        
        Logger.logSection("Paying with PayPal");
        cart.checkout(new PayPalStrategy("user@example.com"));
        
        Logger.logSection("Paying with Bitcoin");
        cart.checkout(new BitcoinStrategy("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa"));
    }
}
