package utility

import commands.*
import java.io.File
import java.sql.DriverManager

class CommandManager(private var asker: BychaAsker) {

    private val last14 = mutableListOf<String>()
    private var listOfCommands = LinkedHashMap<String, AbstractCommand>()

    init {
        fillCollection()
    }

    private fun fillCollection() {
        listOfCommands["help"] = Help()
        listOfCommands["info"] = Info()
        listOfCommands["show"] = Show()
        listOfCommands["add"] = Add()
        listOfCommands["update id"] = Update()
        listOfCommands["remove_by_id"] = RemoveById()
        listOfCommands["clear"] = Clear()
        listOfCommands["save"] = Save()
        listOfCommands["execute_script"] = ExecuteScript()
        listOfCommands["exit"] = Exit()
        listOfCommands["add_if_min"] = AddIfMin()
        listOfCommands["add_if_max"] = AddIfMax()
        listOfCommands["history"] = History()
        listOfCommands["count_less_than_house"] = CountLTH()
        listOfCommands["print_descending"] = PrintDescending()
        listOfCommands["print_field_descending_view"] = PrintFDV()
    }

    fun correctCommand(s: String): Boolean {
        return listOfCommands.containsKey(s)
    }

    fun checkSymbolsOfCommand(s1: String, s2: String): Boolean {
        if (s1 in listOf("help", "show", "info", "clear", "save", "exit", "history", "print_descending", "print_field_descending_view")) {
            return if (s2.isEmpty()) true
            else {
                DriverManager.println("Ошибка! У команды $s1 нет аргументов! Команда должна быть введена без них.")
                false
            }
        }
        if (s1 in listOf("update", "remove_by_id")) {
            return try {
                s2.toInt()
                true
            } catch (e: NumberFormatException) {
                DriverManager.println("Ошибка! id - это целочисленное значение.")
                false
            }
        }
        if (s1 in listOf("count_less_than_house")) {

        }
        if (s1 in listOf("execute_script")) {
            return if (File(s1).exists()) true
            else {
                DriverManager.println("Ошибка! Файл $s2 не найден!")
                false
            }
        }
        return false
    }

    fun DoCommand(str1: String, str2: String): Boolean? {
        if (correctCommand(str1)) {
            println("Используется команда $str1")
            listOfCommands[str1]?.execute((str2 + " " + asker.askForCommandArguments(str1)).trim()).let {
                if (it?.message != null) println(it.message)
                return it?.commandComplicated
            }
        } else {
            println("error: Неправильно введена команда!")
            return false
        }
    }

    fun queue(temp: String) {
        for (i in listOfCommands) {
            if (i.value.getName() == temp) {
                if (last14.size < 14) {
                    last14.add(temp)
                } else {
                    for (i in 1..13) {
                        last14[i-1] = last14[i]
                    }
                    last14[13] = temp
                }
            }
        }
    }

    fun help(): String {
        var commandList = ""
        for (command in listOfCommands) {
            commandList += command.value.getName() + ": " + command.value.getExplanationOfCommand() + "\n"
        }
        return commandList.substring(0, commandList.length - 2)
    }

    fun history(): String {
        var temp = ""
        for (i in 0..13) {
            temp += last14[i] + "\n"
        }
        return temp.substring(0, temp.length - 2)
    }
}