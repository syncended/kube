import dev.syncended.kube.core.Kube
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

fun loadResource(location: String): ByteArray? {
  val url = "/$location".replace("//", "/")
  return Kube::class.java.getResource(url)
    ?.readBytes()
}


fun loadResourceBase64(location: String): String? {
  val raw = loadResource(location) ?: return null
  @OptIn(ExperimentalEncodingApi::class)
  return Base64.encode(raw)
}

fun String.trimSlashes(): String {
  return "/${this.trim('/')}"
}