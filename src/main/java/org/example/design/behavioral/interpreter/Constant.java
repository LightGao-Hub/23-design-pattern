package org.example.design.behavioral.interpreter;

/**
 * Author: GL
 * Date: 2021-12-06
 */
public class Constant extends Expression {

    private final boolean value;

    public Constant(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Constant) {
            return this.value == ((Constant) obj).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {

        return value;
    }

    @Override
    public String toString() {
        return new Boolean(value).toString();
    }

}
