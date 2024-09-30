object PublishingInfo {
  private const val RELEASE_REPO = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
  private const val SNAPSHOT_REPO = "https://s01.oss.sonatype.org/content/repositories/snapshots/"

  const val group = "dev.syncended"

  val mavenRepository: String
    get() = System.getenv("RELEASE_VERSION")
      ?.let { RELEASE_REPO } ?: SNAPSHOT_REPO

  val releaseVersion: String
    get() = System.getenv("RELEASE_VERSION")
      ?: "${System.currentTimeMillis()}-SNAPSHOT"

  val mavenUsername: String
    get() = System.getenv("SONATYPE_USERNAME") ?: ""

  val mavenPassword: String
    get() = System.getenv("SONATYPE_PASSWORD") ?: ""
}