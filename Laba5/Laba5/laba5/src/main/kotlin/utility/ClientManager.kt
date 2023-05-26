package utility

import exceptions.IsEmptyException
import java.io.File
import java.io.FileNotFoundException
import java.util.*

class ClientManager(private var scan: Scanner, private var commandManager: CommandManager, private var asker: BychaAsker) {

    fun checkScript(str: String) {
        try {
            var exitIsThere = false
            var recursionIsThere = false
            var continueDoingScriptCounter = 0

            val file = File(str)
            val scanFile = Scanner(file)
            if (!scanFile.hasNext()) throw IsEmptyException()
            asker.setScan(Scanner(System.`in`))
            var newInput: Array<String>

            while (scanFile.hasNextLine() && continueDoingScriptCounter >= 0) {
                newInput = (scanFile.nextLine().trim() + " ").split(" ").toTypedArray()
                if ((newInput.size == 3 || newInput.size == 4) && newInput[1][0].toString() == "-") {
                    if (commandManager.correctCommand(newInput[0] + " " + newInput[1])) {
                        if (commandManager.checkSymbolsOfCommand(newInput[0] + " " + newInput[1], newInput[2])) {
                            when (newInput[0] + " " + newInput[1]) {
                                "execute_script -delecate" -> {recursionIsThere =  true}
                            }
                        } else continueDoingScriptCounter -= 1
                    } else continueDoingScriptCounter -= 1
                } else {
                    if (commandManager.correctCommand(newInput[0])) {
                        if (commandManager.checkSymbolsOfCommand(newInput[0], newInput[1])) {
                            when (newInput[0]) {
                                "exit" -> {exitIsThere = true}
                                "execute_script" -> {recursionIsThere = true}
                                "add" -> {continueDoingScriptCounter += 12}
                            }
                        }else continueDoingScriptCounter -= 1
                    } else continueDoingScriptCounter -= 1
                }
            }
            if (exitIsThere) {
                if (!asker.askYesOrNot("В скрипте есть выход из программы, выполнить скрипт?")) continueDoingScriptCounter -= 1
            }

            if (recursionIsThere) {
                if (!asker.askYesOrNot("В скрипте есть рекурсия, выполнить скрипт?")) continueDoingScriptCounter -= 1
            }

            if (continueDoingScriptCounter == 0) {
                scriptMode(str)
            } else println("скрипт отменен")

        } catch (e: FileNotFoundException) {
            println("Ошибка! файл с таким именем не найден!")
        } catch (e: IsEmptyException) {
            println("Ошибка! Файл пуст!")
        }
    }

    fun scriptMode(str: String) {
        try {
            val file = File(str)
            val scanFile = Scanner(file)
            if (!scanFile.hasNext()) throw IsEmptyException()
            val oldScan = asker.getScan()
            asker.setScan(scanFile)
            asker.setScriptInProgress()
            var newInput: Array<String>

            while (scanFile.hasNextLine()) {
                newInput = (scanFile.nextLine().trim() + " ").split(" ").toTypedArray()
                if ((newInput.size == 3 || newInput.size == 4) && newInput[1][0].toString() == "-") {
                    commandManager.DoCommand(newInput[0] + " " + newInput[1], newInput[2])
                } else {
                    commandManager.DoCommand(newInput[0], newInput[1])
                }
            }

            asker.setScan(oldScan)
            asker.setScriptNotInProgress()
        } catch (e: FileNotFoundException) {
            println("Ошибка! Файла с таким именем не обнаружено!")
        } catch (e: IsEmptyException) {
            println("Ошибка! Файл пуст!")
        }
    }

    private fun interactiveMode() {
        var newInput: Array<String>
        while (true) {
            newInput = (scan.nextLine().trim() + " ").split(Regex(" ")).toTypedArray()
            if ((newInput.size == 3 || newInput.size == 4) && newInput[1][0].toString() == "-") {
                commandManager.DoCommand(newInput[0] + " " + newInput[1], newInput[2])
            } else {
                commandManager.DoCommand(newInput[0], newInput[1])
            }
        }
    }

    fun run() {
        println("Начало работы программы, для справки по командам введите help")
        interactiveMode()
    }
}