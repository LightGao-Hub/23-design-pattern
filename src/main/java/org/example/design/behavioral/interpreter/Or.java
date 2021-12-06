package org.example.design.behavioral.interpreter;

/**
 * Author: GL
 * Date: 2021-12-06
 */
public class Or extends Expression {
    private final Expression left;
    private final Expression right;

    public Or(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Or) {
            return this.left.equals(((Or) obj).left) && this.right.equals(((Or) obj).right);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {
        return left.interpret(ctx) || right.interpret(ctx);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " OR " + right.toString() + ")";
    }

}
