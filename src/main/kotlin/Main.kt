import de.falsewasnottrue.CartridgeFileLoader
import de.falsewasnottrue.SeekableByteBuffer

fun main(args: Array<String>) {

    val filename = "/parkabenteuer.gwc"
    val resource = CartridgeFileLoader::class.java.getResource(filename)
    val bytes = resource.readBytes()
    val buffer = SeekableByteBuffer(bytes)

    println("Loaded $filename - got ${buffer.size} bytes")

    val loader = CartridgeFileLoader()

    val checked = loader.checkFileSignature(buffer)
    println("checked: $checked")

    val offsets = loader.readOffsets(buffer)
    println("offsets size: ${offsets.size}")
}
