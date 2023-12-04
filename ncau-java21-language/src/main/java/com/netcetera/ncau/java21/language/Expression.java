package com.netcetera.ncau.java21.language;

public sealed interface Expression {

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

//  record ModulusExpression(Expression a, Expression b) implements Expression {
//
//    @Override
//    public int evaluate() {
//      return Math.floorMod(a.evaluate(), b.evaluate());
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
