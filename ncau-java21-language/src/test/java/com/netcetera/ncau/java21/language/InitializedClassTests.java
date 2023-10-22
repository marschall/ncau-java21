package com.netcetera.ncau.java21.language;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InitializedClassTests {

  @Test
  void test() throws ClassNotFoundException {
//    assertNotNull(new InitializedClass());
    assertNotNull(Class.forName("com.netcetera.ncau.java21.language.InitializedClass"));
  }

}
