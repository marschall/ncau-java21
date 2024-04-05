package com.netcetera.ncau.java21.benchmarks;

import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static org.openjdk.jmh.annotations.Mode.AverageTime;
import static org.openjdk.jmh.annotations.Scope.Benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@BenchmarkMode(AverageTime)
@OutputTimeUnit(MICROSECONDS)
@State(Benchmark)
public class GetClassLoaderBenchmarks {

  private Class<?> clazz;

  @Setup
  public void setup() {
    this.clazz = GetClassLoaderBenchmarks.class;
  }

  @Benchmark
  public ClassLoader getClassLoader() {
    return this.clazz.getClassLoader();
  }

}
