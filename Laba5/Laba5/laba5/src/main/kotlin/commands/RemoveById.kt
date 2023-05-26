package commands

import requestManager
import utility.ExecuteCommand

class RemoveById: AbstractCommand("remove_by_id id", "удаляет элемент из коллекции по его id") {

    override fun execute(str: String): ExecuteCommand {
        return requestManager.removeByIdRequest(str)
    }
}