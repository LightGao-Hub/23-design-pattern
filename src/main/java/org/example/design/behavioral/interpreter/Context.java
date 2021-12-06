package org.example.design.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: GL
 * Date: 2021-12-06
 */
public class Context {

    private final Map<Variable, Boolean> map = new HashMap<>();

    public void assign(Variable var, boolean value) {
        map.put(var, value);
    }

    public boolean lookup(Variable var) throws IllegalArgumentException {
        Boolean value = map.get(var);
        if (value == null) {
            throw new IllegalArgumentException();
        }
        return value;
    }
}
