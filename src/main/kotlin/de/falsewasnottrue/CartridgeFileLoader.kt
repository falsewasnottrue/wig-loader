package de.falsewasnottrue

class CartridgeFileLoader {

    // GWC file signature
    val SIGNATURE = byteArrayOf(0x02, 0x0a, 0x43, 0x41, 0x52, 0x54, 0x00)

    fun checkFileSignature(buf: SeekableByteBuffer) =
        SIGNATURE.indices.all {
            buf.nextByte() == SIGNATURE[it]
        }


    fun readOffsets(buf: SeekableByteBuffer): Map<Int, Int> {
        val result = mutableMapOf<Int, Int>()
        val numberOfOffsets = buf.nextByte()

        for (i in 0..numberOfOffsets) {
            val index = buf.nextShort()
            val offset = buf.nextInt()

            result.put(index, offset)
        }

        return result
    }
}
