﻿plugins {
    alias(libs.plugins.bilibilias.android.feature)
    alias(libs.plugins.bilibilias.android.library.compose)
    alias(libs.plugins.bilibilias.android.library.jacoco)
    alias(libs.plugins.bilibilias.android.library.decompose)
}

android {
    namespace = "com.imcys.bilibilias.feature.download"
}

dependencies {
    implementation(projects.feature.common)

    implementation(projects.core.download)
    implementation(projects.core.database)

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
}
