package com.netcetera.ncau.java21.api;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.Locale;

import org.junit.jupiter.api.Test;

class LocaleTests {

  @Test
  void ofCaches() {
    assertSame(Locale.of("de", "CH"), Locale.of("de", "CH"));
  }

}
