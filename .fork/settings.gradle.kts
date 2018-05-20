/*
 * .fork/settings.gradle.kts
 * gradle-xcodePlugin
 */

rootProject.name = "xcodePluginFork"

// Include fork project in composite build
val forkPlugin = file("../../Fork")
if (forkPlugin.exists()) {
    includeBuild(forkPlugin) {
        dependencySubstitution {
            substitute(module("at.phatbl:fork")).with(project(":"))
        }
    }
}

pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "at.phatbl.fork" ->
                    useModule("at.phatbl:fork:${requested.version}")
                else -> Unit
            }
        }
    }
}
