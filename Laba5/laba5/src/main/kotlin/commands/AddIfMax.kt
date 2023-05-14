package commands

import requestManager
import utility.ExecuteCommand

class AddIfMax: AbstractCommand("add_if_max {element}", "добавляет новый элемент в коллекцию, если площадь квартиры больше, чем у элемента с наибольшей площадью") {

    override fun execute(str: String): ExecuteCommand {
        return requestManager.checkIfMaxArea(str)
    }
}