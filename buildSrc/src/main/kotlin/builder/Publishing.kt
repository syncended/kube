package builder

import PublishingInfo
import eu.kakde.sonatypecentral.SonatypeCentralPublishExtension
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByType
import org.gradle.plugins.signing.SigningExtension
import java.net.URI

fun Project.setupPublishing(archiveName: String) {
  setupSigning()
  setupSonatypeExt(archiveName)
}

private fun Project.setupSigning() {
  extensions.getByType<SigningExtension>().apply {
    useGpgCmd()
    useInMemoryPgpKeys(
      PublishingInfo.gpgId,
      PublishingInfo.gpgKey,
      PublishingInfo.gpgPassword
    )
  }
}

private fun Project.setupSonatypeExt(archiveName: String) {
  extensions.getByType<SonatypeCentralPublishExtension>().apply {
    username.set(PublishingInfo.mavenUsername)
    password.set(PublishingInfo.mavenPassword)

    groupId.set(PublishingInfo.group)
    artifactId.set(archiveName)
    version.set(PublishingInfo.releaseVersion)
    componentType.set("java")
    publishingType.set("AUTOMATIC")

    pom {
      name.set(archiveName)
      description.set("KUBE Library")
      url.set("https://github.com/syncended/kube")
      scm {
        connection.set("scm:git:https://github.com/syncended/kube")
        developerConnection.set("scm:git:https://github.com/syncended/")
        url.set("https://github.com/syncended/kube")
      }

      licenses {
        license {
          name.set("Apache-2.0 license")
          url.set("https://www.apache.org/licenses/LICENSE-2.0")
        }
      }
      developers {
        developer {
          id.set("syncended")
          name.set("Mikhail Ivanov")
          email.set("syncended@gmail.com")
        }
      }
    }
  }
}
