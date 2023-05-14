package commands

import requestManager
import utility.ExecuteCommand

class PrintFDV: AbstractCommand("print_field_descending_view", "выводит значения поля view всех элементов в порядке убывания") {

    override fun execute(str: String): ExecuteCommand {
        return requestManager.printFieldDescendingViewRequest(str)
    }
}