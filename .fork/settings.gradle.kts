/*
 * .fork/settings.gradle.kts
 * gradle-xcodePlugin
 */

rootProject.name = "xcodePluginFork"

// Include fork project in composite build from any of these locations
run loop@{
    listOf(
        file("../../Fork"),
        file("build/dependencies/Fork")
    ).forEach {
        if (it.exists()) {
            includeBuild(it) {
                dependencySubstitution {
                    substitute(module("at.phatbl:fork")).with(project(":"))
                }
            }
            // Break out of forEach to only take the first location found
            return@loop
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
