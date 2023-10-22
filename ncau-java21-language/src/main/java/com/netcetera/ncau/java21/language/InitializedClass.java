package com.netcetera.ncau.java21.language;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InitializedClass {
  
  private static final Logger LOG;
  
  static {
    LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    LOG.info("<clinit>");
  }

  public InitializedClass() {
    LOG.info("<init>");
  }

}
