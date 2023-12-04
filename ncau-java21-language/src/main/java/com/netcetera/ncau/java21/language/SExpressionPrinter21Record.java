package com.netcetera.ncau.java21.language;

import java.util.Objects;

import com.netcetera.ncau.java21.language.Expression.ConstantExpression;
import com.netcetera.ncau.java21.language.Expression.NegateExpression;
import com.netcetera.ncau.java21.language.Expression.PlusExpression;
import com.netcetera.ncau.java21.language.Expression.TimesExpression;

public final class SExpressionPrinter21Record implements SExpressionPrinter {

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
      if (e instanceof NegateExpression(Expression n)) {
        buffer.append("- ");
        printTo(n, buffer);
      }
      buffer.append(')');
    }
  }

}