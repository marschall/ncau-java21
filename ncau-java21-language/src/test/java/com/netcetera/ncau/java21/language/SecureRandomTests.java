package com.netcetera.ncau.java21.language;

import java.lang.invoke.MethodHandles;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SecureRandomTests {
  
  private static final Logger LOG = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

  private SecureRandom random;

  @BeforeEach
  void setUp() throws GeneralSecurityException {
    this.random = SecureRandom.getInstance("NativePRNGNonBlocking");
  }

  @Test
  void nextInt() throws InterruptedException, NoSuchAlgorithmException {
    Thread randomThread = Thread.ofVirtual()
      .name("secure-random-thread")
      .start(() -> {
        for (int i = 0; i < 100_000; i++) {
          if (random.nextInt() == 42) {
            LOG.info(".");
          }
        }
      });
    randomThread.join();
  }

}
