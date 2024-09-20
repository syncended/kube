import dev.syncended.kube.core.Kube

fun loadResource(location: String): ByteArray? {
  val url = "/$location".replace("//", "/")
  return Kube::class.java.getResource(url)
    ?.readBytes()
}