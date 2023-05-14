package commands

import requestManager
import utility.ExecuteCommand

class AddIfMin: AbstractCommand("add_if_min {element}", "добавляет новый элемент в коллекцию, если площадь квартиры меньше, чем у элемента с наименьшей площадью") {

    override fun execute(str: String): ExecuteCommand {
        return requestManager.checkIfMinArea(str)
    }
}