package com.patterns.structural;

import com.patterns.common.Demonstrable;
import com.patterns.common.Logger;
import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Pattern - Uses sharing to support large numbers of
 * fine-grained objects efficiently.
 */
public final class FlyweightPattern implements Demonstrable {
    
    // Flyweight
    private interface TreeType {
        void render(int x, int y);
    }
    
    // Concrete Flyweight
    private static final class ConcreteTreeType implements TreeType {
        private final String name;
        private final String color;
        private final String texture;
        
        public ConcreteTreeType(String name, String color, String texture) {
            this.name = name;
            this.color = color;
            this.texture = texture;
            Logger.log("Creating tree type: " + name);
        }
        
        @Override
        public void render(int x, int y) {
            Logger.log("  Rendering " + name + " tree at (" + x + "," + y + 
                      ") [" + color + ", " + texture + "]");
        }
    }
    
    // Flyweight Factory
    private static final class TreeFactory {
        private static final Map<String, TreeType> treeTypes = new HashMap<>();
        
        public static TreeType getTreeType(String name, String color, String texture) {
            String key = name + "-" + color + "-" + texture;
            return treeTypes.computeIfAbsent(key, 
                k -> new ConcreteTreeType(name, color, texture));
        }
        
        public static int getTypeCount() {
            return treeTypes.size();
        }
    }
    
    // Context
    private static final class Tree {
        private final int x;
        private final int y;
        private final TreeType type;
        
        public Tree(int x, int y, TreeType type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
        
        public void render() {
            type.render(x, y);
        }
    }
    
    @Override
    public void demonstrate() {
        Logger.logPattern("Flyweight Pattern");
        
        Logger.logSection("Creating Trees");
        Tree[] forest = new Tree[6];
        forest[0] = new Tree(1, 2, TreeFactory.getTreeType("Oak", "Green", "Rough"));
        forest[1] = new Tree(3, 4, TreeFactory.getTreeType("Pine", "Dark Green", "Smooth"));
        forest[2] = new Tree(5, 6, TreeFactory.getTreeType("Oak", "Green", "Rough"));
        forest[3] = new Tree(7, 8, TreeFactory.getTreeType("Pine", "Dark Green", "Smooth"));
        forest[4] = new Tree(9, 10, TreeFactory.getTreeType("Oak", "Green", "Rough"));
        forest[5] = new Tree(11, 12, TreeFactory.getTreeType("Birch", "White", "Smooth"));
        
        Logger.logSection("Rendering Forest");
        for (Tree tree : forest) {
            tree.render();
        }
        
        Logger.log("\nTotal trees: " + forest.length);
        Logger.log("Unique tree types (flyweights): " + TreeFactory.getTypeCount());
    }
}
