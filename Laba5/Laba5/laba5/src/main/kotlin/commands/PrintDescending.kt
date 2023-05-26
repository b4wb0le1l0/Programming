package commands

import requestManager
import utility.ExecuteCommand

class PrintDescending: AbstractCommand("print_descending", "выводит элементы коллекции в порядке убывания") {

    override fun execute(str: String): ExecuteCommand {
        return requestManager.printDescendingRequest(str)
    }
}