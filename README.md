# 🧩 Java Design Patterns Homework

This project demonstrates the implementation of several **object-oriented design patterns** in **Java** through console-based ASCII art rendering of geometric shapes.

The program can draw different shapes and showcases the following **design patterns**:

- **Composite Pattern**
- **Flyweight Pattern**
- **Builder Pattern**
- **Command Pattern**

---

## 📁 Project Structure

# 🧩 Java Design Patterns Homework

This project demonstrates the implementation of several **object-oriented design patterns** in **Java** through console-based ASCII art rendering of geometric shapes.

The program can draw different shapes and showcases the following **design patterns**:

- **Composite Pattern**
- **Flyweight Pattern**
- **Builder Pattern**
- **Command Pattern**

---

## 📁 Project Structure

# 🧩 Java Design Patterns Homework

This project demonstrates the implementation of several **object-oriented design patterns** in **Java** through console-based ASCII art rendering of geometric shapes.

The program can draw different shapes and showcases the following **design patterns**:

- **Composite Pattern**
- **Flyweight Pattern**
- **Builder Pattern**
- **Command Pattern**

---

## 📁 Project Structure

src/
└── main/
└── java/
└── hu/homework/patterns/shapes/
├── AsciiRenderer.java
├── Brush.java
├── BrushFactory.java ← Flyweight Pattern
├── Shape.java
├── ShapeGroup.java ← Composite Pattern
├── RectangleShape.java
├── TrapezoidShape.java
├── RhombusShape.java
├── PyramidShape.java
├── EllipseShape.java
├── builder/
│ └── ShapeBuilder.java ← Builder Pattern
├── command/
│ ├── Command.java
│ ├── DrawShapeCommand.java
│ └── Invoker.java ← Command Pattern
└── ShapesApp.java ← Application entry point


---

## 🚀 How to Run

### 1. **Demo Mode (no arguments)**
When run without parameters, the application automatically demonstrates all implemented patterns.

```bash
java -cp target/homeworkfirst-1.0-SNAPSHOT.jar hu.homework.patterns.shapes.ShapesApp
