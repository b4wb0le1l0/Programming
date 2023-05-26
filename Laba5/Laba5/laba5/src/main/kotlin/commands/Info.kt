package commands

import requestManager
import utility.ExecuteCommand

class Info : AbstractCommand("info", "выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.") {

    override fun execute(str: String): ExecuteCommand {
        return requestManager.infoRequest(str)
    }
}