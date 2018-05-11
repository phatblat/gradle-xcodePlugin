/*
 * .fork/build.gradle.kts
 * gradle-xcodePlugin
 */

/* -------------------------------------------------------------------------- */
// 🛃 Imports
/* -------------------------------------------------------------------------- */

import at.phatbl.shellexec.ShellCommand
import at.phatbl.shellexec.ShellExec

/* -------------------------------------------------------------------------- */
// 🔌 Plugins
/* -------------------------------------------------------------------------- */

plugins {
     id("at.phatbl.clamp") version "1.1.0"
     id("at.phatbl.shellexec") version "1.1.3"
}

/* -------------------------------------------------------------------------- */
// 👪 Dependencies
/* -------------------------------------------------------------------------- */

repositories.jcenter()
dependencies {
//    implementation("org.ajoberstar:grgit:+")
}

/* -------------------------------------------------------------------------- */
// ☑️ Tasks
/* -------------------------------------------------------------------------- */

tasks {
    val listRemotes by creating(ShellExec::class) {
        command = "git remote -v"
    }
}
