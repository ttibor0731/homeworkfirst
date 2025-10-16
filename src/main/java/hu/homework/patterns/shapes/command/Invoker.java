package hu.homework.patterns.shapes.command;

import java.util.ArrayList;
import java.util.List;

/** Invoker: stores and triggers commands. */
public final class Invoker {
    private final List<DrawCommand> queue = new ArrayList<>();
    public Invoker add(DrawCommand cmd){ queue.add(cmd); return this; }
    public void runAll(){
        for (DrawCommand c : queue){
            System.out.println(">> " + c.label());
            c.execute();
            System.out.println();
        }
    }
}

