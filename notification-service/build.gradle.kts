plugins {
    alias(libs.plugins.spring.boot)
}

springBoot {
    mainClass.set("com.github.alxsshv.paymentplatform.notificationservice.NotificationServiceApplication")
}

dependencies {
    implementation(libs.spring.boot.starter.validation)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    testImplementation(libs.spring.boot.starter.test)
    testRuntimeOnly(libs.junit.platform.launcher)
}