plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.shoppish"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.shoppish"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {



    val nav_version = "2.7.4"

    implementation ("androidx.compose.ui:ui:1.0.5")
    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("io.coil-kt:coil-compose:2.4.0")
    implementation ("io.coil-kt:coil-compose:2.1.0")
    implementation ("com.google.firebase:firebase-auth")
    implementation ("androidx.compose.ui:ui-tooling:1.6.7")
    implementation ("androidx.compose.ui:ui-graphics:1.3.2")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.google.firebase:firebase-analytics")
    implementation ("androidx.compose.material:material:1.0.5")
    implementation ("androidx.activity:activity-compose:1.6.1")
    implementation ("androidx.compose.material3:material3:1.2.1")
    implementation ("com.google.android.material:material:1.4.0")
    implementation ("androidx.compose.material3:material3:1.1.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation ("com.google.accompanist:accompanist-insets:0.17.0")
    implementation (platform("com.google.firebase:firebase-bom:33.1.2"))
    implementation ("androidx.navigation:navigation-compose:$nav_version")
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.16.0")
    implementation ("androidx.compose.material:material-icons-extended:1.0.0-alpha08")



    testImplementation(libs.junit)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.core.ktx)
    implementation(libs.navigation.compose)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.graphics)
    debugImplementation(libs.androidx.ui.tooling)
    androidTestImplementation(libs.androidx.junit)
    implementation(libs.androidx.activity.compose)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    androidTestImplementation(platform(libs.androidx.compose.bom))


//    implementation("androidx.compose.material:material-icons-extended-android:1.5.0:")


}