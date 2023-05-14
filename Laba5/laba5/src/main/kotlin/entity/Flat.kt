package entity

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import java.math.BigInteger
import java.util.*

object FlatSerializer : KSerializer<Date> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("Date", PrimitiveKind.LONG)

    override fun serialize(encoder: kotlinx.serialization.encoding.Encoder, value: Date) {
        encoder.encodeLong(value.time)
    }

    override fun deserialize(decoder: Decoder): Date {
        return Date(decoder.decodeLong())
    }
}

@Serializable(with = FlatSerializer::class)
data class Flat(
    @Serializable(with = FlatSerializer::class)
    private var id: Int,
    private var name: String,
    private var coordinates: Coordinates,
    private var creationDate: Date,
    private var area: Int,
    private var numberOfRooms: BigInteger,
    private var furnish: Furnish,
    private var view: View,
    private var transport: Transport,
    private var house: House): Comparable<Flat> {

    fun getId(): Int {
        return this.id
    }

    fun getArea(): Int {
        return this.area
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + coordinates.hashCode()
        result = 31 * result + creationDate.hashCode()
        result = 31 * result + area.hashCode()
        result = 31 * result + numberOfRooms.hashCode()
        result = 31 * result + furnish.hashCode()
        result = 31 * result + view.hashCode()
        result = 31 * result + transport.hashCode()
        result = 31 * result + house.hashCode()
        return result
    }

    override fun toString(): String {
        return "Flat(id=$id, name='$name', coordinates=$coordinates, creationDate=$creationDate, area=$area, numberOfRooms=$numberOfRooms, furnish=$furnish, view=$view, transport=$transport, house=$house)"
    }

    override fun compareTo(other: Flat): Int {
        return this.id.compareTo(other.getId())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Flat

        if (id != other.id) return false
        if (name != other.name) return false
        if (coordinates != other.coordinates) return false
        if (creationDate != other.creationDate) return false
        if (area != other.area) return false
        if (numberOfRooms != other.numberOfRooms) return false
        if (furnish != other.furnish) return false
        if (view != other.view) return false
        if (transport != other.transport) return false
        if (house != other.house) return false

        return true
    }
}