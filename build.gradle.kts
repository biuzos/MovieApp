// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.3.1" apply false
    id("com.android.library") version "8.3.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply false
<<<<<<< Updated upstream
    id("org.sonarqube") version "4.4.1.3373" apply false
=======
    id("org.sonarqube") version "3.3" apply false
>>>>>>> Stashed changes
}

buildscript {
    dependencies {
        classpath(Libs.DaggerHilt.getDaggerHiltPluginVersion())
        classpath("com.android.tools.build:gradle:8.3.1")
        classpath("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:4.4.1.3373")
    }
}



