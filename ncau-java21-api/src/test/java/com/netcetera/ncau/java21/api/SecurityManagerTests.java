package com.netcetera.ncau.java21.api;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SecurityManagerTests {

  @Test
  void setSecurityManager() {
    assertThrows(UnsupportedOperationException.class, () -> System.setSecurityManager(new SecurityManager()));
  }

}
