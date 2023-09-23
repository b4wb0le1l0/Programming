package utility

import authManager
import logger
import java.io.IOException
import java.io.NotSerializableException
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.net.ServerSocket
import java.net.Socket
import java.util.*

class ServerManager(
    private var scan: Scanner,
    private var commandExecuter: CommandExecuter
) {

    private var serverSocket: ServerSocket? = null
    private val port = 4747
    private lateinit var clientSocket: Socket
    private lateinit var inputStream: ObjectInputStream
    private lateinit var outputStream: ObjectOutputStream
    private lateinit var request: Request
    private lateinit var response: CommandResult

    fun getServerSocket(): ServerSocket? {
        return serverSocket
    }

    fun run() {
        openServer()
        while (true) {
            try {
                clientSocket = connectToClient()!!
                executeRequest(clientSocket)
            } catch (e: NullPointerException) {
                break
            }
        }
    }

    private fun openServer() {
        try {
            logger.info("Запуск сервера...")
            serverSocket = ServerSocket(port)
            logger.info("Сервер успешно запущен")
        } catch (e: IOException) {
            logger.error("Произошла ошибка при запуске сервера!")
        }
    }


    private fun connectToClient(): Socket? {
        return try {
            logger.info("Подключение клиента...")
            clientSocket = serverSocket!!.accept()
            logger.info("Клиент успешно подключен")
            clientSocket
        } catch (e: IOException) {
            null
        } catch (e: NullPointerException) {
            logger.error("Порт $port занят")
            null
        }
    }

    private fun executeRequest(clientSocket: Socket) {
        try {
            inputStream = ObjectInputStream(clientSocket.getInputStream())
            outputStream = ObjectOutputStream(clientSocket.getOutputStream())
            request = inputStream.readObject() as Request
            logger.info("Получен запрос от клиента")
            response = commandExecuter.executeCommand(request.commandName, request.commandArguments) !!
            logger.info("Готов ответ клиенту\nОтправка")

            if (response.commandComplicated == StateOfResponse.CLIENT_EXIT) logger.info("Клиент " + clientSocket.inetAddress.hostName + " отключился")
            outputStream.writeObject(response)

        } catch (e: ClassNotFoundException) {
            logger.error("Произошла ошибка при чтении данных от клиента")
        } catch (e: NotSerializableException) {
            logger.error("Ошибка при отправлении данных клиенту")
        } catch (e: IOException) {
            logger.error("Разрыв соединения с клиентом")
        }
    }
}