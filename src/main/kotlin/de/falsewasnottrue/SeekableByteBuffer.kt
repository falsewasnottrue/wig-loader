package de.falsewasnottrue

class SeekableByteBuffer(private val buffer: ByteArray, private var pos: Int = 0) {

    val size = buffer.size

    fun seek(updatedPos: Int) {
        pos = updatedPos
    }

    fun nextByte(): Byte = buffer[pos++]

    fun nextShort(): Int {
        val h = buffer[pos++]
        val l = buffer[pos++]

        return h*256+l
    }

    fun nextInt(): Int {
        var res = buffer[pos++].toInt()
        for (i in 0..2) {
            res = res*256 + buffer[pos++]
        }
        return res
    }
}
