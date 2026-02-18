package com.patterns.structural;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;

/**
 * Proxy Pattern - Provides a surrogate or placeholder for another object
 * to control access to it.
 */
public final class ProxyPattern implements Demonstrable {
    
    // Subject
    private interface Image {
        void display();
    }
    
    // Real Subject
    private static final class RealImage implements Image {
        private final String fileName;
        
        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromDisk();
        }
        
        private void loadFromDisk() {
            Logger.log("Loading image from disk: " + fileName);
        }
        
        @Override
        public void display() {
            Logger.log("Displaying image: " + fileName);
        }
    }
    
    // Proxy
    private static final class ProxyImage implements Image {
        private final String fileName;
        private RealImage realImage;
        
        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }
        
        @Override
        public void display() {
            if (realImage == null) {
                Logger.log("Proxy: First access, creating real image");
                realImage = new RealImage(fileName);
            } else {
                Logger.log("Proxy: Using cached image");
            }
            realImage.display();
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Proxy Pattern");
        
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");
        
        Logger.logSection("First access to image1");
        image1.display();
        
        Logger.logSection("Second access to image1 (cached)");
        image1.display();
        
        Logger.logSection("First access to image2");
        image2.display();
    }
}
