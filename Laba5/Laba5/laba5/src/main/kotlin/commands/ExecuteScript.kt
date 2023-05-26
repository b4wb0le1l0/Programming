package commands

import asker
import commandManager
import scan
import utility.ClientManager
import utility.ExecuteCommand

class ExecuteScript: AbstractCommand("execute_script file_name", "считает и исполняет скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме") {

    override fun execute(str: String): ExecuteCommand {
        val clientManager = ClientManager(scan, commandManager, asker)
        clientManager.scriptMode(str)
        return ExecuteCommand(true)
    }

}