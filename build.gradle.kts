plugins {
    java
    jacoco
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.sonarqube)
}

group = "com.github.alxsshv"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}


// Настройки, применяемые ко ВСЕМ подпроектам
subprojects {
    apply(plugin = "java")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "jacoco")

    repositories {
        mavenCentral()
    }

    tasks.test {
        useJUnitPlatform()
        finalizedBy(tasks.jacocoTestReport)
    }

    tasks.jacocoTestReport {
        dependsOn(tasks.test)
        reports {
            xml.required.set(true)
            html.required.set(true)
            csv.required.set(false)
        }
        finalizedBy(tasks.jacocoTestCoverageVerification)
    }

    tasks.jacocoTestCoverageVerification {
        violationRules {
            rule {
                limit {
                    counter = "INSTRUCTION"
                    minimum = "0.35".toBigDecimal()
                }
            }
        }
    }
}

sonar {
    properties {
        property("sonar.projectKey", "alxsshv_paymentplatform")
        property("sonar.projectName", "payment-platform")

        property("sonar.coverage.jacoco.xmlReportPaths", "build/reports/jacoco/test/jacocoTestReport.xml")
    }
}