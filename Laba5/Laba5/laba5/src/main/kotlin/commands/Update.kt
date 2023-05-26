package commands

import requestManager
import utility.ExecuteCommand

class Update: AbstractCommand("update id {element}", "обновляет значение элемента коллекции, id которого равен заданному"){

    override fun execute(str: String): ExecuteCommand {
        return requestManager.updateByIdRequest(str)
    }
}