package com.acme;

import java.util.Objects;

import com.acme.Reproducer.Expression.ConstantExpression;
import com.acme.Reproducer.Expression.PlusExpression;
import com.acme.Reproducer.Expression.TimesExpression;

public class Reproducer {

  public static void main(String[] args) {
    SExpressionPrinter printer = new SExpressionPrinter21Record();
    Expression twoPlusThree = new PlusExpression(new ConstantExpression(2), new ConstantExpression(3));
    System.out.println(printer.print(twoPlusThree));
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
      } else {
        buffer.append('(');
        if (e instanceof PlusExpression(Expression a, Expression b)) {
          buffer.append("+ ");
          printTo(a, buffer);
          buffer.append(' ');
          printTo(b, buffer);
        }
        if (e instanceof TimesExpression(Expression a, Expression b)) {
          buffer.append("* ");
          printTo(a, buffer);
          buffer.append(' ');
          printTo(b, buffer);
        }
        buffer.append(')');
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

    record PlusExpression(Expression a, Expression b) implements Expression {

      @Override
      public int evaluate() {
        return Math.addExact(a.evaluate(), b.evaluate());
      }

    }

    record TimesExpression(Expression a, Expression b) implements Expression {

      @Override
      public int evaluate() {
        return Math.multiplyExact(a.evaluate(), b.evaluate());
      }

    }

  }

}
