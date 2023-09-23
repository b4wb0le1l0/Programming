package utility

import entity.Flat
import entity.View
import java.time.LocalDateTime

class EntityManager() {

    private var flatCollection = LinkedHashSet<Flat>()
    private var lastInitTime: LocalDateTime? = null
    private var lastSaveTime: LocalDateTime? = null

    fun getFlatCollection(): LinkedHashSet<Flat>{
        return this.flatCollection
    }

    fun getLastInitTime(): String {
        return if (lastInitTime == null) {
            "иницилизация еще не произовидилась"
        } else lastInitTime.toString()
    }

    fun getLastSaveTime(): String {
        return if (lastSaveTime == null) {
            "сохранение еще не производилось"
        } else lastSaveTime.toString()
    }

    fun getCollectionType(): String {
        return this.flatCollection.javaClass.typeName
    }

    fun getCollectionSize(): Int {
        return this.flatCollection.size
    }

    fun getById(id: Int): Flat? {
        return flatCollection.find { flat -> flat.getId() == id }
    }

    fun generateId(): Int {
        if (flatCollection.isEmpty()) return 1
        return flatCollection.last().getId() + 1
    }

    fun setLastSaveTime(data: LocalDateTime) {
        this.lastSaveTime = data
    }

    fun addObjectToCollection(flat: Flat) {
        flatCollection.add(flat)
    }

    fun removeFromCollection(flat: Flat) {
        flatCollection.remove(flat)
    }

    fun areaMin(int: Int): Boolean {
        return int < flatCollection.minOf { flat -> flat.getArea() }
    }

    fun areaMax(int: Int): Boolean {
        return int > flatCollection.minOf { flat -> flat.getArea() }
    }

    fun clearCollection() {
        flatCollection.clear()
    }

    fun getCountLessThanHouse(): Int {
        return 0
    }

    fun getInDescending(): String {
        val list = ArrayList<String>()
        ((flatCollection.sortedByDescending { flat -> flat.getId() }).forEach { flat -> list.add(flat.getId().toString()) })
        return list.joinToString()
    }

    fun getViewInDescending(): String {
        val list = View.values()
        list.sortedDescending().forEach {  }
        return list.joinToString()
    }

    override fun toString(): String {
        return "EntityManager(flatCollection=$flatCollection, lastInitTime=$lastInitTime, lastSaveTime=$lastSaveTime)"
    }
}