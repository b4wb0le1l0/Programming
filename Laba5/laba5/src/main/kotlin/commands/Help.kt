package commands

import requestManager
import utility.ExecuteCommand

class Help: AbstractCommand("help", "выводит справку по доступным командам") {

    override fun execute(str: String): ExecuteCommand{
        return requestManager.helpRequest(str)
    }
}