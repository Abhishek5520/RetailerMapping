plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.buzzar.retailerMapping"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.buzzar.retailerMapping"
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

    implementation("androidx.core:core-ktx:1.12.0")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.moshi:moshi-kotlin:1.9.3")
//    implementation ("com.squareup.retrofit2:retrofit:2.2.0")
    implementation("androidx.navigation:navigation-compose:2.4.0-beta02")
    implementation ("com.squareup.retrofit2:converter-gson:2.2.0")
    implementation ("com.google.accompanist:accompanist-permissions:0.20.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0-beta02")

    implementation ("androidx.camera:camera-camera2:1.2.3")
    implementation ("androidx.camera:camera-lifecycle:1.2.3")
    implementation ("androidx.camera:camera-view:1.3.0-beta01")

    implementation ("com.google.mlkit:vision-common:17.3.0")
    implementation ("com.google.android.gms:play-services-mlkit-text-recognition-common:19.0.0")
    implementation ("com.google.android.gms:play-services-mlkit-text-recognition:19.0.0")

//    implementation ("io.insert-koin:koin-core:3.4.6")
//    implementation ("io.insert-koin:koin-android:3.4.6")
//    implementation ("io.insert-koin:koin-androidx-compose:3.4.6")
//
//    implementation ("io.insert-koin:koin-annotations:3.4.6")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.7.0")


    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation ("com.github.skydoves:landscapist-coil:1.4.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation ("androidx.compose.material:material-icons-extended")
    implementation(platform("androidx.compose:compose-bom:2024.01.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}