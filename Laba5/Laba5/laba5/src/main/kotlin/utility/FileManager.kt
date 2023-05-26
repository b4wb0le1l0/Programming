package utility

import entity.Flat
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.*
import java.util.*
import kotlin.collections.LinkedHashSet

class FileManager (private var name: String, private var asker: BychaAsker) {

    private fun setName(name: String) {
        this.name = name
    }

    fun writeCollection(collection: LinkedHashSet<Flat>) {
        try {
            val list = ArrayList(collection)
            FileWriter(name).use { it.write(Json.encodeToString(list)) }
        } catch (e: IOException) {
            println("Ошибка! Невозможно сохранить!")
        }
    }

    fun readCollection(): LinkedHashSet<Flat> {
        var fileReader: FileReader
        while (true) {
            try {
                fileReader = FileReader(name)
                break
            } catch (e: FileNotFoundException) {
                println("Ошибка! Файла с таким названием не существует!")
                setName(asker.askForFileName())
            }
        }
        var char: Int
        var input = ""
        do {
            char = fileReader.read()
            if (char == -1) {
                break
            }
            input += char.toChar()
        } while (true)
        return LinkedHashSet(Json.decodeFromString<List<Flat>>(input))
    }
}