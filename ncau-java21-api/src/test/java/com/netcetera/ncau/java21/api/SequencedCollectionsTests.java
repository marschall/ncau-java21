package com.netcetera.ncau.java21.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class SequencedCollectionsTests {

  @Test
  void reversed() {
    List<String> letters = List.of("A", "B", "C");
    for (String letter : letters.reversed()) {
      assertNotNull(letter);
    }
  }

}
