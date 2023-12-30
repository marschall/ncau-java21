package com.netcetera.ncau.java21.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
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

  @Test
  void firstLast() {
    List<String> letters = new ArrayList<>(List.of("A", "B", "C"));
    assertEquals("A", letters.getFirst());
    assertEquals("C", letters.getLast());

    letters.addFirst("z");
    letters.addLast("D");
    assertEquals(List.of("z", "A", "B", "C", "D"), letters);
  }

  @Test
  void reversedAddFirst() {
    List<String> letters = new ArrayList<>(List.of("A", "B", "C"));
    letters.reversed().add("z");
    assertEquals(List.of("z", "A", "B", "C"), letters);
  }

}
