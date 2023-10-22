package com.netcetera.ncau.java21.language;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;

import org.junit.jupiter.api.Test;

class SynchronizedIoInJdkTests {

  @Test
  void serviceLoader() {
    ServiceLoader<IServiceInterface> serviceLoader = ServiceLoader.load(IServiceInterface.class);
    List<IServiceInterface> services = serviceLoader.stream()
      .map(Provider::get)
      .toList();
    assertEquals(1, services.size());
  }

}
