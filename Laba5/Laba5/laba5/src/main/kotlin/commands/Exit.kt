package commands

import requestManager
import utility.ExecuteCommand

class Exit: AbstractCommand("exit", "завершает программу (без сохранения в файл)") {

    override fun execute(str: String): ExecuteCommand {
        return requestManager.exitRequest(str)
    }
}