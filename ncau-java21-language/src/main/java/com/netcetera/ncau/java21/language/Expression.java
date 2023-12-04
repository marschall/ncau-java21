package com.netcetera.ncau.java21.language;

public sealed interface Expression {
  // no need for permits since we're using inner classes

  int evaluate();

  // no need for final since we're using records
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

//  record DivideExpression(Expression a, Expression b) implements Expression {
//
//    @Override
//    public int evaluate() {
//      return Math.divideExact(a.evaluate(), b.evaluate());
//    }
//
//  }

  record NegateExpression(Expression e) implements Expression {

    @Override
    public int evaluate() {
      return Math.negateExact(e.evaluate());
    }

  }

}
