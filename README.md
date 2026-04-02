# Gang of Four Design Patterns - Java 24 POC

A comprehensive demonstration of all 23 Gang of Four (GoF) design patterns implemented in Java 24 with strict adherence to Object-Oriented principles.

## Project Structure

```
gof_patterns/
├── src/main/java/com/patterns/
│   ├── Main.java                          # Main demonstration class
│   ├── common/                            # Common utilities
│   │   ├── Demonstrable.java              # Common interface for all patterns
│   │   └── Logger.java                    # Logging utility
│   ├── creational/                        # Creational Patterns (5)
│   │   ├── AbstractFactoryPattern.java
│   │   ├── BuilderPattern.java
│   │   ├── FactoryMethodPattern.java
│   │   ├── PrototypePattern.java
│   │   └── SingletonPattern.java
│   ├── structural/                        # Structural Patterns (7)
│   │   ├── AdapterPattern.java
│   │   ├── BridgePattern.java
│   │   ├── CompositePattern.java
│   │   ├── DecoratorPattern.java
│   │   ├── FacadePattern.java
│   │   ├── FlyweightPattern.java
│   │   └── ProxyPattern.java
│   └── behavioral/                        # Behavioral Patterns (11)
│       ├── ChainOfResponsibilityPattern.java
│       ├── CommandPattern.java
│       ├── InterpreterPattern.java
│       ├── IteratorPattern.java
│       ├── MediatorPattern.java
│       ├── MementoPattern.java
│       ├── ObserverPattern.java
│       ├── StatePattern.java
│       ├── StrategyPattern.java
│       ├── TemplateMethodPattern.java
│       └── VisitorPattern.java
└── pom.xml
```

## Design Patterns Overview

### Creational Patterns (5)
Deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.

1. **Singleton** - Ensures a class has only one instance
2. **Factory Method** - Defines an interface for creating objects
3. **Abstract Factory** - Creates families of related objects
4. **Builder** - Separates object construction from representation
5. **Prototype** - Creates objects by cloning prototypes

### Structural Patterns (7)
Deal with object composition and relationships between entities.

1. **Adapter** - Converts one interface to another
2. **Bridge** - Decouples abstraction from implementation
3. **Composite** - Composes objects into tree structures
4. **Decorator** - Adds responsibilities to objects dynamically
5. **Facade** - Provides a unified interface to a subsystem
6. **Flyweight** - Shares objects to support large numbers efficiently
7. **Proxy** - Provides a surrogate for another object

### Behavioral Patterns (11)
Deal with object collaboration and the delegation of responsibilities.

1. **Chain of Responsibility** - Passes requests along a chain of handlers
2. **Command** - Encapsulates requests as objects
3. **Interpreter** - Implements a specialized language
4. **Iterator** - Provides sequential access to elements
5. **Mediator** - Defines simplified communication between classes
6. **Memento** - Captures and restores object state
7. **Observer** - Notifies dependents of state changes
8. **State** - Alters behavior when internal state changes
9. **Strategy** - Encapsulates interchangeable algorithms
10. **Template Method** - Defines algorithm skeleton
11. **Visitor** - Separates algorithms from object structure

## Object-Oriented Principles Applied

- **Encapsulation**: Each pattern properly encapsulates its implementation details
- **Abstraction**: Interfaces and abstract classes define contracts
- **Inheritance**: Used appropriately for code reuse and polymorphism
- **Polymorphism**: Leveraged through interfaces and abstract classes
- **SOLID Principles**:
  - Single Responsibility Principle
  - Open/Closed Principle
  - Liskov Substitution Principle
  - Interface Segregation Principle
  - Dependency Inversion Principle

## Requirements

- Java 24 or higher
- Maven 3.9.0 or higher

## Building the Project

```bash
# Compile the project
mvn clean compile

# Package as JAR
mvn clean package
```

## Running the Demonstration

```bash
# Using Maven
mvn exec:java

# Using JAR
java -jar target/gof-patterns-1.0.0.jar

# Using Java directly
java -cp target/classes com.patterns.Main
```

## Features

- ✅ All 23 GoF patterns implemented
- ✅ Each pattern in a separate file
- ✅ Common utilities in shared package
- ✅ Strict OO principles adherence
- ✅ Clear demonstration output
- ✅ Comprehensive documentation
- ✅ Java 24 features utilized

## Key Design Decisions

1. **Common Interface**: All patterns implement `Demonstrable` for consistency
2. **Logger Utility**: Centralized logging for clean output
3. **Final Classes**: Most implementation classes are final to prevent misuse
4. **Private Constructors**: Utility classes have private constructors
5. **Nested Classes**: Pattern implementations use nested classes for encapsulation
6. **Type Safety**: Generic types used where appropriate

## Educational Value

This POC demonstrates:
- How to implement each GoF pattern correctly
- When and where to apply each pattern
- Real-world examples for each pattern
- Best practices in Java design
- Modern Java features (Java 24)

## Author

Gang of Four Design Patterns POC - Java 24 Implementation

## License

Educational purposes - feel free to learn and adapt!
