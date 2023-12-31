package com.acme;

import com.acme.Reproducer.Expression.ConstantExpression;

public class Reproducer {

  public static void main(String[] args) {
    SExpressionPrinter printer = new SExpressionPrinter();
    Expression constant = new ConstantExpression(2);
    System.out.println(printer.print(constant));
  }

  static final class SExpressionPrinter {

    public String print(Expression e) {
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

    record ConstantExpression(int i) implements Expression {

    }

  }

}
