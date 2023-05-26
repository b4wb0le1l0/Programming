package commands

import requestManager
import utility.ExecuteCommand

class CountLTH: AbstractCommand("count_less_that_house", "выводит количество элементов, значение поля house которых меньше заданного") {

    override fun execute(str: String): ExecuteCommand {
        return requestManager.countLessThanHouseRequest(str)
    }
}