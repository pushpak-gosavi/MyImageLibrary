import com.android.build.gradle.internal.scope.InternalArtifactType
import com.android.build.gradle.internal.testing.utp.ADDITIONAL_TEST_OUTPUT_MIN_API_LEVEL
import com.android.sdklib.computeFullReleaseName
import com.android.sdklib.computeReleaseNameAndDetails
import com.google.protobuf.Api
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.rootPublicationComponentName

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.pushpak.image_preview"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.pushpak-gosavi"
            artifactId = "image-preview-compose"
            version = "1.0"
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}

