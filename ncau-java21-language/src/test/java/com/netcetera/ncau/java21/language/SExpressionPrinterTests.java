package com.netcetera.ncau.java21.language;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.netcetera.ncau.java21.language.Expression.ConstantExpression;
import com.netcetera.ncau.java21.language.Expression.PlusExpression;

class SExpressionPrinterTests {

  @ParameterizedTest
  @MethodSource
  void print(SExpressionPrinter printer) {
    Expression twoPlusThree = new PlusExpression(new ConstantExpression(2), new ConstantExpression(3));
    assertEquals("(+ 2 3)", printer.print(twoPlusThree));
  }

  static List<SExpressionPrinter> print() {
    return List.of(
        new SExpressionPrinter17(),
        new SExpressionPrinter21Record(),
        new SExpressionPrinter21Switch(),
        new SExpressionPrinter21SwitchPlusRecord());
  }

}
