package com.patterns.structural;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;
import java.util.ArrayList;
import java.util.List;

/**
 * Composite Pattern - Composes objects into tree structures to represent
 * part-whole hierarchies.
 */
public final class CompositePattern implements Demonstrable {
    
    // Component
    private interface FileSystemComponent {
        void display(int depth);
        int getSize();
    }
    
    // Leaf
    private static final class File implements FileSystemComponent {
        private final String name;
        private final int size;
        
        public File(String name, int size) {
            this.name = name;
            this.size = size;
        }
        
        @Override
        public void display(int depth) {
            Logger.log("  ".repeat(depth) + "- File: " + name + " (" + size + "KB)");
        }
        
        @Override
        public int getSize() {
            return size;
        }
    }
    
    // Composite
    private static final class Directory implements FileSystemComponent {
        private final String name;
        private final List<FileSystemComponent> children = new ArrayList<>();
        
        public Directory(String name) {
            this.name = name;
        }
        
        public void add(FileSystemComponent component) {
            children.add(component);
        }
        
        @Override
        public void display(int depth) {
            Logger.log("  ".repeat(depth) + "+ Directory: " + name);
            for (FileSystemComponent child : children) {
                child.display(depth + 1);
            }
        }
        
        @Override
        public int getSize() {
            return children.stream().mapToInt(FileSystemComponent::getSize).sum();
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Composite Pattern");
        
        Directory root = new Directory("root");
        Directory docs = new Directory("documents");
        Directory images = new Directory("images");
        
        docs.add(new File("report.pdf", 1024));
        docs.add(new File("notes.txt", 256));
        
        images.add(new File("photo1.jpg", 2048));
        images.add(new File("photo2.jpg", 1536));
        
        root.add(docs);
        root.add(images);
        root.add(new File("readme.md", 128));
        
        Logger.logSection("File System Structure");
        root.display(0);
        Logger.log("\nTotal size: " + root.getSize() + "KB");
    }
}
