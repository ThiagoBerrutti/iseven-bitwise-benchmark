plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("kapt") version "1.4.32"
    id("me.champeau.gradle.jmh") version "0.5.2"
    id("io.morethan.jmhreport") version "0.9.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0-RC2")

    kapt("org.openjdk.jmh:jmh-generator-annprocess:1.25")

    implementation("org.openjdk.jmh:jmh-core:1.25")
    implementation("org.openjdk.jmh:jmh-generator-annprocess:1.25")

    api("ch.qos.logback:logback-classic:1.2.3")
    implementation("net.logstash.logback:logstash-logback-encoder:6.4")

    annotationProcessor("org.openjdk.jmh:jmh-generator-annprocess:1.25")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

task("benchmarks", type = JavaExec::class) {
    classpath = sourceSets.getByName("test").runtimeClasspath
    mainClass = "com.example.benchmark.BenchmarkKt"
}
