package com.netcetera.ncau.java21.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EmojiTests {

  @Test
  void isEmoji() {
    String informationDesk = "💁🏻‍♂️";
    assertEquals(7, informationDesk.length(), "length");

    assertTrue(Character.isEmoji(informationDesk.codePointAt(0)), "isEmoji");
    assertTrue(Character.isEmojiPresentation(informationDesk.codePointAt(0)), "isEmojiPresentation");
    assertTrue(Character.isEmojiModifierBase(informationDesk.codePointAt(0)), "isEmojiModifierBase");

    assertTrue(Character.isEmoji(informationDesk.codePointAt(2)), "isEmoji");
    assertTrue(Character.isEmojiPresentation(informationDesk.codePointAt(2)), "isEmojiPresentation");
    assertTrue(Character.isEmojiComponent(informationDesk.codePointAt(2)), "isEmojiModifierBase");
    assertTrue(Character.isEmojiModifier(informationDesk.codePointAt(2)), "isEmojiModifier");
  }

}
