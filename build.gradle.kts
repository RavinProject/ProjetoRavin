import org.gradle.kotlin.dsl.java

plugins {
    java
    id("jvm-test-suite")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

group = "org.ravin"
version = "0.2.0-SNAPSHOT"

repositories.mavenCentral()

dependencies {
    val junitVersion = "5.9.2"
    val mockitoVersion = "5.3.1"
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
}

testing{
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
        }

        register<JvmTestSuite>("integrationTest") {
            dependencies {
                implementation(project())
            }

            targets {
                all {
                    testTask.configure {
                        shouldRunAfter(test)
                    }
                }
            }
        }
    }
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "org.ravin.App"
    }
}