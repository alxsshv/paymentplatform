plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "paymentplatform"


include("payment-core")
include("notification-service")
