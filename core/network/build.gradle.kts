import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "${AppConfig.applicationId}.core.network"
    compileSdk = AppConfig.compileSdkVersion

    defaultConfig {
        minSdk = AppConfig.minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        //load the values from .properties file
        val keystoreFile = project.rootProject.file("apikey.properties")
        val properties = Properties()
        properties.load(keystoreFile.inputStream())
        //return empty key in case something goes wrong
        val apiKey = properties.getProperty("API_KEY") ?: ""
        val baseUrlImage = properties.getProperty("BASE_URL_IMAGE") ?: ""
        val baseUrl = properties.getProperty("BASE_URL") ?: ""
        buildConfigField(type = "String", name = "API_KEY", value = apiKey)
        buildConfigField(type = "String", name = "BASE_URL_IMAGE", value = baseUrlImage)
        buildConfigField(type = "String", name = "BASE_URL", value = baseUrl)


    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(project(":commons"))
    implementation(Libs.Kotlin.coreKtxVersion())
    implementation(Libs.Kotlin.getAppCompact())


    // Retrofit
    api(Libs.Retrofit.getRetrofitCoreVersion())
    api(Libs.Retrofit.getRetrofitGsonVersion())
    api(Libs.OkHttp3.getCoreVersion())
    api(Libs.OkHttp3.getInterceptorVersion())

    //DI - Hilt
    implementation(Libs.DaggerHilt.getDaggerHiltAndroidVersion())
    implementation(Libs.DaggerHilt.getDaggerHiltNavigationComposeVersion())
    ksp(Libs.DaggerHilt.getDaggerHiltCompilerVersion())
    ksp(Libs.Hilt.getHiltCompilerVersion())

    //Gson
    implementation(Libs.Gson.getGsonVersion())

    testImplementation(Libs.Test.getJunitVersion())
}