plugins {
    kotlin("multiplatform") version "1.9.0"
}

group = "dev.yjyoon"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    wasm {
        binaries.executable()
        browser {

        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting
        val wasmMain by getting
        val wasmTest by getting
    }
}
