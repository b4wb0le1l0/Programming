package commands

import utility.ExecuteCommand
import requestManager

class Add: AbstractCommand("add {element}", "добавляет новый элемент в коллекцию") {

    override fun execute(str: String): ExecuteCommand {
        return requestManager.addRequest(null, str)
    }
}