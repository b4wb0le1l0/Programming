package commands

import requestManager
import utility.ExecuteCommand

class Show: AbstractCommand("show", "выводит в стандартный поток вывода все элементы коллекции в строковом представлении"){

    override fun execute(str: String): ExecuteCommand {
        return requestManager.showRequest(str)
    }
}