package commands

import utility.ExecuteCommand
import requestManager

class Save: AbstractCommand("save", "сохраняет коллекцию в файл") {

    override fun execute(str: String): ExecuteCommand{
        return requestManager.saveRequest(str)
        return ExecuteCommand(true, "Бучу")
    }
}