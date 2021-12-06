package org.example.design.behavioral.interpreter;

/**
 * Author: GL
 * Date: 2021-12-06
 */
public class Variable extends Expression {

    private final String name;

    public Variable(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Variable) {
            return this.name.equals(((Variable)obj).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean interpret(Context ctx) {
        return ctx.lookup(this);
    }

}
