//import kotlinx.coroutines.runBlocking
import com.example.benchmark.BenchmarkExample
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.openjdk.jmh.results.format.ResultFormatType
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.RunnerException
import org.openjdk.jmh.runner.options.Options
import org.openjdk.jmh.runner.options.OptionsBuilder
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.measureTime

fun isEvenModulo(number: Int): Boolean {
    return number % 2 == 0
}

fun isEvenBitwise(number: Int): Boolean {
    return number and 1 == 0
}

fun main() {
        val opt: Options = OptionsBuilder()
            .include(BenchmarkExample::class.java.simpleName)
            .forks(1)
            .threads(2)
            .warmupBatchSize(2)
            .warmupIterations(2)
            .measurementIterations(100)
            .resultFormat(ResultFormatType.JSON)
            .output("build/benchmark_output.log")
            .result("build/benchmark_result.json")
            .build()


            Runner(opt).run()

}
