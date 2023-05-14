package utility

import entity.*
import java.time.Instant
import java.time.LocalDateTime
import java.util.*
import kotlin.system.exitProcess

class RequestManager (private var entityManager: EntityManager, private var asker: BychaAsker, private var fileManager: FileManager, private var commandManager: CommandManager){

    fun helpRequest(str: String): ExecuteCommand {
        return if (str.isEmpty()) {
            ExecuteCommand(true, commandManager.help())
        }else ExecuteCommand(false, "Ошибка! После команды help не должно быть аргументов")
    }

    fun historyRequest(str: String):ExecuteCommand {
        return if (str.isEmpty()) {
            ExecuteCommand(true, commandManager.history())
        }else return ExecuteCommand(false, "Ошибка! После команды history не должно быть аргументов")
    }

    fun exitRequest(str: String): ExecuteCommand {
        if (str.isEmpty()) {
            exitProcess(0)
        } else return ExecuteCommand(false, "Ошибка! После команды exit не должно быть аргументов")
    }

    fun infoRequest(str: String): ExecuteCommand {
        return if (str.isEmpty()) {
            ExecuteCommand(true, "Информация о коллекции:\n" +
                    " Тип коллекции: " + entityManager.getCollectionType() + "\n" +
                    " Размер коллекции: " + entityManager.getCollectionSize() + "\n" +
                    " Дата и время последнего сохранения: " + entityManager.getLastSaveTime() + "\n" +
                    " Дата и время последней иницилизации: " + entityManager.getLastInitTime())
        } else ExecuteCommand(false,"Ошибка! После команды exit не должно быть аргументов")
    }

    fun showRequest(str: String): ExecuteCommand {
        return if (str.isEmpty()) {
            ExecuteCommand(true, entityManager.toString())
        } else ExecuteCommand(false, "Ошибка! После команды show не должно быть аргументов")
    }

    fun addRequest(id: Int?, str: String): ExecuteCommand {
        val listOfArguments = str.split(Regex(" ")).toTypedArray()
        return if(listOfArguments.size == 11) {
            entityManager.addObjectToCollection(
                Flat(
                    ((id ?: entityManager.generateId())),
                    listOfArguments[0],
                    Coordinates(listOfArguments[1].toInt(), listOfArguments[2].toInt()),
                    Date.from(Instant.now()),
                    listOfArguments[3].toInt(),
                    listOfArguments[4].toBigInteger(),
                    Furnish.valueOf(listOfArguments[5]),
                    View.valueOf(listOfArguments[6]),
                    Transport.valueOf(listOfArguments[7]),
                    House(listOfArguments[8], listOfArguments[9].toLong(), listOfArguments[10].toInt())
                ))
            ExecuteCommand(true, "Квартира создана и добавлена в колекцию")
        } else ExecuteCommand(false, "Ошибка! После команды add не должно быть аргументов")
    }

    fun clearRequest(str: String): ExecuteCommand {
        return if (str.isEmpty()) {
            if (entityManager.getCollectionSize() == 0) {
                ExecuteCommand(false, "Коллекция пустая")
            } else {
                entityManager.clearCollection()
                ExecuteCommand(true, "Коллекция очищена")
            }
        } else ExecuteCommand(false, "Ошибка! После команды clear не должно быть аргументов")
    }

    fun checkIfMinArea(str: String): ExecuteCommand {
        val listOfArguments = str.split(Regex(" ")).toTypedArray()
        return if(listOfArguments.size == 11) {
            if (entityManager.areaMin(listOfArguments[3].toInt())) {
                addRequest(null, str)
            } else ExecuteCommand(true, "Есть элемент с меньшей площадью.")
        } else ExecuteCommand(false, "Ошибка! После команды add_if_min не должно быть аргемнтов")
    }

    fun checkIfMaxArea(str: String): ExecuteCommand {
        val listOfArguments = str.split(Regex(" ")).toTypedArray()
        return if(listOfArguments.size == 11) {
            if (entityManager.areaMax(listOfArguments[3].toInt())) {
                addRequest(null, str)
            } else ExecuteCommand(true, "Есть элемент с большей площадью.")
        } else ExecuteCommand(false, "Ошибка! После команды add_if_max не должно быть аргемнтов")
    }

    fun saveRequest(str: String): ExecuteCommand {
        return if (str.isEmpty()) {
            fileManager.writeCollection(entityManager.getFlatCollection())
            entityManager.setLastSaveTime(LocalDateTime.now())
            ExecuteCommand(true, "Коллекция сохранена на файл")
        } else ExecuteCommand(false, "Ошибка! После команды save не должно быть аргументов")
    }

    fun removeByIdRequest(str: String): ExecuteCommand {
        if (str.isNotEmpty()) {
            try {
                if (entityManager.getCollectionSize() == 0) {
                    return ExecuteCommand(true, "Коллекция пустая")
                } else {
                    val flat = entityManager.getById(str.toInt()) ?: return ExecuteCommand(true,"Нет квартиры с заданным id")
                    entityManager.removeFromCollection(flat)
                    return ExecuteCommand(true, "Квартира удалена")
                }
            } catch (e: NumberFormatException) { return ExecuteCommand(false, "Ошибка! Некорректный ввод данных")
            }
        } else return ExecuteCommand(false, "Ошибка! После команды remove_by_id должно быть указано id")
    }

    fun updateByIdRequest(str: String): ExecuteCommand {
        if (str.split(Regex(" ")).toTypedArray().size == 15) {
            try {
                if (entityManager.getCollectionSize() == 0) {
                    return ExecuteCommand(true, "Коллекция пуста")
                } else {
                    var listOfArguments = str.split(Regex(" ")).toTypedArray()
                    val flat = entityManager.getById(listOfArguments[0].toInt()) ?: return ExecuteCommand(true, "Нет квартиры с таким id")
                    val id = listOfArguments[0].toInt()
                    entityManager.removeFromCollection(flat)

                    val list = listOfArguments.toMutableList()
                    list.removeAt(0)
                    listOfArguments = list.toTypedArray()

                    return addRequest(id, listOfArguments.joinToString(separator = " "))
                }
            }catch (e: NumberFormatException) { return ExecuteCommand(false, "Ошибка! Некорректный ввод данных") }
        } else return ExecuteCommand(false, "Ошибка! После команды update должно быть указано id")
    }

    fun countLessThanHouseRequest(str: String): ExecuteCommand {
        return if (str.isEmpty()) {
            if (entityManager.getCollectionSize() == 0) {
                ExecuteCommand(true, "Коллекция пуста")
            } else ExecuteCommand(true, "Количество элементов у которых значение поля house меньше заданного по годам(year): "+entityManager.getCountLessThanHouse(str.toInt()))
        } else ExecuteCommand(false, "Ошибка! После команды count_less_than_house должно быть указано id")
    }

    fun printDescendingRequest(str: String): ExecuteCommand {
        return if (str.isEmpty()) {
            if (entityManager.getCollectionSize() == 0) {
                ExecuteCommand(true, "Коллекция пуста")
            } else ExecuteCommand(true, "Квартир в порядке убывания по id: " + entityManager.getInDescending())
        } else ExecuteCommand(false, "Ошибка! После команды print_descending не должно быть аргументов")
    }

    fun printFieldDescendingViewRequest(str: String): ExecuteCommand {
        return if (str.isEmpty()) {
            if (entityManager.getCollectionSize() == 0) {
                ExecuteCommand(true, "Коллекция пуста")
            } else ExecuteCommand(true, "Знаечения поля view всех существующих квартир в порядке убывания.: " + entityManager.getViewInDescending())
        } else ExecuteCommand(false, "Ошибка! После команды print_field_descending_view не должно быть аргументов")
    }
}