package entity

import kotlinx.serialization.Serializable

@Serializable
data class House(
    private var name: String,
    private var year: Long,
    private var numberOfLifts: Int
){

    fun setName(name: String) {
        if (name != null) this.name = name
    }
    fun setYear(year: Int) {
        if (year > 974 && year <= 0) println("Неккоректный возраст дома.")
        else this.year = year.toLong()
    }
    fun setNumberOfLifts(numberOfLifts: Int) {
        if (numberOfLifts <= 0) println("Incorrect number of lifts in house.")
        else this.numberOfLifts = numberOfLifts
    }
    fun getName(): String {
        return this.name
    }
    fun getYear(): Long {
        return this.year
    }
    fun getNumberOfLifts(): Int {
        return this.numberOfLifts
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as House

        if (name != other.name) return false
        if (year != other.year) return false
        if (numberOfLifts != other.numberOfLifts) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = (31 * result + year).toInt()
        result = 31 * result + numberOfLifts.hashCode()
        return result
    }

    override fun toString(): String {
        return "House(name='$name', year=$year, numberOfLifts=$numberOfLifts)"
    }
}