package entity

import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    private var x: Int,
    private var y: Int) {

    fun setX(x: Long) {
        if (x > 430) println("Incorrect coordinate(x).")
        else this.x
    }
    fun setY(y: Int) {
        if (y != null) this.y
    }
    fun getX(): Int {
        return this.x
    }
    fun getY(): Int {
        return this.y
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Coordinates

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        return result
    }

    override fun toString(): String {
        return "Coordinates(x=$x, y=$y)"
    }
}