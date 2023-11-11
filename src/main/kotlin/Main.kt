import de.falsewasnottrue.CartridgeFileLoader

fun main(args: Array<String>) {

    val filename = "/parkabenteuer.gwc"
    val resource = CartridgeFileLoader::class.java.getResource(filename)
    val bytes = resource.readBytes()

    println("Loaded $filename - got ${bytes.size} bytes")


    val loader = CartridgeFileLoader()

    val checked = loader.checkFileSignature(bytes)
    println("checked: $checked")
}
