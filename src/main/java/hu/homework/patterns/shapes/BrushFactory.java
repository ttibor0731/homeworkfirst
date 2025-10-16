package hu.homework.patterns.shapes;

import java.util.HashMap;
import java.util.Map;

/** Flyweight factory – caches Brush instances by (char, outline) key. */
public final class BrushFactory {
    private static final Map<String, Brush> CACHE = new HashMap<>();
    private BrushFactory() {}
    public static Brush get(char fillChar, boolean outline) {
        String key = fillChar + ":" + outline;
        return CACHE.computeIfAbsent(key, k -> new Brush(fillChar, outline));
    }
    public static int cacheSize() { return CACHE.size(); }
}

