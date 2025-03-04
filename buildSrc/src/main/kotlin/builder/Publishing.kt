package builder

import PublishingInfo
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.gradle.plugins.signing.SigningExtension
import org.jreleaser.gradle.plugin.JReleaserExtension
import org.jreleaser.model.Active
import java.io.File

private val Project.java: JavaPluginExtension
  get() = extensions.getByType()

private val Project.signing: SigningExtension
  get() = extensions.getByType()

private val Project.publishing: PublishingExtension
  get() = extensions.getByType()

private val Project.jReleaser: JReleaserExtension
  get() = extensions.getByType()

private val Project.stagingDir: File
  get() = layout.buildDirectory.dir("staging").get().asFile

fun Project.setupPublishing(archiveName: String) {
  setupJava()
  setupPublications(archiveName)
  setupJReleaser()
  jReleaserTask()
}

fun Project.jReleaserTask() {
  tasks["publish"].doFirst {
    File(layout.buildDirectory.get().asFile, "jreleaser").mkdirs()
  }
}

private fun Project.setupJava() = java.apply {
  withJavadocJar()
  withSourcesJar()
}

private fun Project.setupPublications(archiveName: String) = publishing.apply {
  publications {
    repositories {
      maven { url = stagingDir.toURI() }
    }
    create<MavenPublication>("mavenPublications") {
      from(components["java"])
      groupId = PublishingInfo.group
      artifactId = archiveName
      version = PublishingInfo.releaseVersion

      pom {
        name = archiveName
        description = "KUBE Library"
        url = "https://github.com/syncended/kube"
        scm {
          connection = "scm:git:https://github.com/syncended/kube"
          developerConnection = "scm:git:https://github.com/syncended/"
          url = "https://github.com/syncended/kube"
        }

        licenses {
          license {
            name = "Apache-2.0 license"
            url = "https://www.apache.org/licenses/LICENSE-2.0"
          }
        }
        developers {
          developer {
            id = "syncended"
            name = "Mikhail Ivanov"
            email = "syncended@gmail.com"
          }
        }
      }
    }
  }
}

private fun Project.setupJReleaser() = jReleaser.apply {
  dryrun = false
  gitRootSearch = true
  version = PublishingInfo.releaseVersion

  signing {
    active = Active.ALWAYS
    armored = true
    verify = true
    artifacts = true
    files = true

    publicKey = PublishingInfo.gpgPublicKey
    secretKey = PublishingInfo.gpgKey
    passphrase = PublishingInfo.gpgPassword
  }
  deploy {
    maven {
      mavenCentral {
        active = Active.ALWAYS
        create("sonatype") {
          active = Active.ALWAYS
          url = "https://central.sonatype.com/api/v1/publisher"
          println("Sign dir: ${stagingDir}")
          stagingRepository(stagingDir.toString())

          username = PublishingInfo.mavenUsername
          password = PublishingInfo.mavenPassword
          retryDelay = 60
        }
      }
    }
  }
  release {
    github {
      skipRelease = true
      skipTag = true
      overwrite = false
      token = "none"
    }
  }
}