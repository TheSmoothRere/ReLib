plugins {
    id("net.fabricmc.fabric-loom")
}

fun prop(name: String): String {
    val value = project.findProperty(name)
        ?: error("Required property '$name' is missing from gradle.properties!")
    return value.toString()
}

val modVersion = prop("modVersion")
val modId = prop("modId")
val modName = prop("modName")
val modDescription = prop("modDescription")
val modLicense = prop("modLicense")
val minecraftVersion = prop("minecraftVersion")
val fabricApiVersion = prop("fabricApiVersion")
val javaVersion = prop("javaVersion")

version = modVersion

base {
    archivesName.set(modId)
}

loom {
    splitEnvironmentSourceSets()

    mods {
        create(modId) {
            sourceSet(sourceSets.getByName("main"))
            sourceSet(sourceSets.getByName("client"))
        }
    }

    runs {
        named("client") {
            client()
            generateRunConfig.set(true)
        }
    }
}

dependencies {
    minecraft("com.mojang:minecraft:$minecraftVersion")
    implementation(libs.fabric.loader)

    implementation(provider {
        include(fabricApi.module("fabric-api-base", fabricApiVersion))
        include(fabricApi.module("fabric-resource-loader-v1", fabricApiVersion))
    })
}

tasks.processResources {
    val resourceReplacements = mapOf(
        "version" to modVersion,
        "id" to modId,
        "name" to modName,
        "description" to modDescription,
        "license" to modLicense,
        "minecraftVersion" to minecraftVersion,
        "fabricApiVersion" to fabricApiVersion,
        "javaVersion" to javaVersion
    )

    inputs.properties(resourceReplacements)
    filesMatching("fabric.mod.json") {
        expand(resourceReplacements)
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(javaVersion.toInt())
}

java {
    withSourcesJar()

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion))
    }
}