package com.netcetera.ncau.java21.language;

import java.util.Objects;

import com.netcetera.ncau.java21.language.Expression.ConstantExpression;
import com.netcetera.ncau.java21.language.Expression.NegateExpression;
import com.netcetera.ncau.java21.language.Expression.PlusExpression;
import com.netcetera.ncau.java21.language.Expression.TimesExpression;

public final class SExpressionPrinter21SwitchPlusRecord implements SExpressionPrinter {

  @Override
  public String print(Expression e) {
    Objects.requireNonNull(e);
    StringBuilder buffer = new StringBuilder();
    printTo(e, buffer);
    return buffer.toString();
  }

  private void printTo(Expression e, StringBuilder buffer) {
    switch (e) {
      case ConstantExpression(int i) -> buffer.append(i);
      case PlusExpression(Expression a, Expression b) -> {
        buffer.append("(+ ");
        printTo(a, buffer);
        buffer.append(' ');
        printTo(b, buffer);
        buffer.append(')');
      }
      case TimesExpression(Expression a, Expression b) -> {
        buffer.append("(* ");
        printTo(a, buffer);
        buffer.append(' ');
        printTo(b, buffer);
        buffer.append(')');
      }
      case NegateExpression(Expression n) -> {
        buffer.append("(- ");
        printTo(n, buffer);
        buffer.append(')');
      }
    }
  }

}