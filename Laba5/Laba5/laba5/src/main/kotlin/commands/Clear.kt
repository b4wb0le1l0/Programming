package commands

import requestManager
import utility.ExecuteCommand

class Clear: AbstractCommand("clear", "очищает коллекцию") {

    override fun execute(str: String): ExecuteCommand {
        return requestManager.clearRequest(str)
    }
}