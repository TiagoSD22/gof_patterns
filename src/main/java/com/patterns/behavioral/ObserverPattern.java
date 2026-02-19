package com.patterns.behavioral;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * Observer Pattern - Defines a one-to-many dependency between objects
 * so that when one object changes state, all its dependents are notified.
 */
public final class ObserverPattern implements Demonstrable {
    
    // Observer interface
    private interface Observer {
        void update(String news);
    }
    
    // Subject interface
    private interface Subject {
        void attach(Observer observer);
        void detach(Observer observer);
        void notifyObservers();
    }
    
    // Concrete Subject
    private static final class NewsAgency implements Subject {
        private final List<Observer> observers = new ArrayList<>();
        private String news;
        
        public void setNews(String news) {
            this.news = news;
            Logger.log("NewsAgency: Publishing news - " + news);
            notifyObservers();
        }
        
        @Override
        public void attach(Observer observer) {
            observers.add(observer);
        }
        
        @Override
        public void detach(Observer observer) {
            observers.remove(observer);
        }
        
        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(news);
            }
        }
    }
    
    // Concrete Observer
    private static final class NewsChannel implements Observer {
        private final String name;
        
        public NewsChannel(String name) {
            this.name = name;
        }
        
        @Override
        public void update(String news) {
            Logger.log("  " + name + " received: " + news);
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Observer Pattern");
        
        NewsAgency agency = new NewsAgency();
        
        NewsChannel cnn = new NewsChannel("CNN");
        NewsChannel bbc = new NewsChannel("BBC");
        NewsChannel fox = new NewsChannel("FOX");
        
        agency.attach(cnn);
        agency.attach(bbc);
        agency.attach(fox);
        
        Logger.logSection("Breaking News 1");
        agency.setNews("Major earthquake detected!");
        
        Logger.logSection("Breaking News 2");
        agency.setNews("Stock market reaches all-time high!");
    }
}
