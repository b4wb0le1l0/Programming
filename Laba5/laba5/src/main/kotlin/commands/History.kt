package commands

import requestManager
import utility.ExecuteCommand

class History: AbstractCommand("history", "выводит последние 14 команд(без их аргументов)") {

    override fun execute(str: String): ExecuteCommand {
        return requestManager.historyRequest(str)
    }
}