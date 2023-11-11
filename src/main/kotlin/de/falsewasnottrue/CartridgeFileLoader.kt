package de.falsewasnottrue

class CartridgeFileLoader {

    // GWC file signature
    val SIGNATURE = byteArrayOf(0x02, 0x0a, 0x43, 0x41, 0x52, 0x54, 0x00)

    fun checkFileSignature(bytes: ByteArray) =
        SIGNATURE.indices.all {
            bytes[it] == SIGNATURE[it]
        }

}
