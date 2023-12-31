package com.acme;

import java.util.Objects;

import com.acme.Reproducer.Expression.ConstantExpression;

public class Reproducer {

  public static void main(String[] args) {
    SExpressionPrinter printer = new SExpressionPrinter21Record();
    Expression constant = new ConstantExpression(2);
    System.out.println(printer.print(constant));
  }

  interface SExpressionPrinter {

    String print(Expression e);

  }

  static final class SExpressionPrinter21Record implements SExpressionPrinter {

    @Override
    public String print(Expression e) {
      Objects.requireNonNull(e);
      StringBuilder buffer = new StringBuilder();
      printTo(e, buffer);
      return buffer.toString();
    }

    private void printTo(Expression e, StringBuilder buffer) {
      if (e instanceof ConstantExpression(int i)) {
        buffer.append(i);
      }
    }
  }

  sealed interface Expression {

    int evaluate();

    record ConstantExpression(int i) implements Expression {

      @Override
      public int evaluate() {
        return i;
      }

    }

  }

}
