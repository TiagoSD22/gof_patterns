package com.patterns.behavioral;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Iterator Pattern - Provides a way to access the elements of an aggregate
 * object sequentially without exposing its underlying representation.
 */
public final class IteratorPattern implements Demonstrable {
    
    // Iterator interface
    private interface Iterator<T> {
        boolean hasNext();
        T next();
    }
    
    // Aggregate interface
    private interface Container<T> {
        Iterator<T> createIterator();
    }
    
    // Concrete Aggregate
    private static final class BookCollection implements Container<String> {
        private final List<String> books = new ArrayList<>();
        
        public void addBook(String book) {
            books.add(book);
        }
        
        @Override
        public Iterator<String> createIterator() {
            return new BookIterator();
        }
        
        // Concrete Iterator
        private final class BookIterator implements Iterator<String> {
            private int index = 0;
            
            @Override
            public boolean hasNext() {
                return index < books.size();
            }
            
            @Override
            public String next() {
                if (hasNext()) {
                    return books.get(index++);
                }
                return null;
            }
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Iterator Pattern");
        
        BookCollection collection = new BookCollection();
        collection.addBook("Design Patterns");
        collection.addBook("Clean Code");
        collection.addBook("Refactoring");
        collection.addBook("The Pragmatic Programmer");
        
        Logger.logSection("Iterating through books");
        Iterator<String> iterator = collection.createIterator();
        while (iterator.hasNext()) {
            Logger.log("Book: " + iterator.next());
        }
    }
}
