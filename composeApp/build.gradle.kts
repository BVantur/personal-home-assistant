import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    id("dev.icerock.mobile.multiplatform-resources")
    id("com.google.gms.google-services") version "4.4.0"
}

kotlin {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    
    jvm("desktop")
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = false
            // TODO if changing static to true add below code as Run Script Phase in xCode
//            "$SRCROOT/../gradlew" -p "$SRCROOT/../" :composeApp:copyFrameworkResourcesToApp \
//            -Pmoko.resources.PLATFORM_NAME="$PLATFORM_NAME" \
//            -Pmoko.resources.CONFIGURATION="$CONFIGURATION" \
//            -Pmoko.resources.ARCHS="$ARCHS" \
//            -Pmoko.resources.BUILT_PRODUCTS_DIR="$BUILT_PRODUCTS_DIR" \
//            -Pmoko.resources.CONTENTS_FOLDER_PATH="$CONTENTS_FOLDER_PATH"

            export("dev.icerock.moko:graphics:0.9.0") // toUIColor here
        }
    }
    
    sourceSets {
        val androidMain by getting {
            dependsOn(commonMain.get())

            dependencies {
                implementation(libs.compose.ui)
                implementation(libs.compose.ui.tooling.preview)
                implementation(libs.androidx.activity.compose)
                implementation(project.dependencies.platform("com.google.firebase:firebase-bom:32.5.0"))
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
        val commonMain by getting {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.voyager.navigator)
                implementation(libs.voyager.bottom.sheet.navigator)
                implementation(libs.voyager.tab.navigator)
                implementation(libs.voyager.transitions)
                implementation(libs.voyager.koin)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                api(libs.moko.resources.compose)
                api(libs.moko.resources)
                @OptIn(ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                implementation(libs.firebase.auth)
            }
        }

        val iosMain by getting {
            dependsOn(commonMain)
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting {
            dependsOn(iosMain)
        }
    }
}

android {
    namespace = "sp.bvantur.assistant"
    compileSdk = 34

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        applicationId = "sp.bvantur.assistant"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "sp.bvantur.assistant" // required
    multiplatformResourcesSourceSet = "commonMain"
    multiplatformResourcesClassName = "SharedRes"
    disableStaticFrameworkWarning = true
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "sp.bvantur.assistant"
            packageVersion = "1.0.0"
        }
    }
}
