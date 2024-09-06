package com.example.benchmark


import isEvenBitwise
import isEvenModulo
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import java.util.concurrent.TimeUnit


const val iterations = 1_000_000_000

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
open class BenchmarkExample {

    @Benchmark
    fun benchmarkIsEvenModulo() {
        repeat(iterations) {
            isEvenModulo(123456789)
        }
    }

    @Benchmark
    fun benchmarkIsEvenBitwise() {
        repeat(iterations) {
            isEvenBitwise(123456789)
        }
    }
}