package utility

import java.io.*
import java.net.Socket
import java.sql.DriverManager

class ClientManager(private var asker: BychaAsker) {


    private var listOfCommands = ArrayList<String>()
    private val port = 4747
    private lateinit var sock: Socket
    private lateinit var outputStream: ObjectOutputStream
    private lateinit var inputStream: ObjectInputStream
    private var serverToken: String? = null
    private val last14 = mutableListOf<String>()

    init {
        fillCollection()
    }

    private fun fillCollection() {
        listOfCommands.add("help")
        listOfCommands.add("info")
        listOfCommands.add("show")
        listOfCommands.add("add")
        listOfCommands.add("update")
        listOfCommands.add("remove_by_id")
        listOfCommands.add("clear")
        listOfCommands.add("save")
        listOfCommands.add("execute_script")
        listOfCommands.add("exit")
        listOfCommands.add("add_if_min")
        listOfCommands.add("add_if_max")
        listOfCommands.add("history")
        listOfCommands.add("count_less_than_house")
        listOfCommands.add("print_descending")
        listOfCommands.add("print_field_descending_view")
    }

    fun getUsername(): String? {
        return serverToken?.let { Regex("^\\w+").find(it)?.value }
    }

    fun sendCommandToServer(str1: String, str2: String): StateOfResponse {
        try {
            connectToServer()
            outputStream.writeObject(Request(str1, (str2 + " " + asker.askForCommandArguments(str1)).trim(), serverToken))
            (inputStream.readObject() as CommandResult).let {
                if (it.message != null) println(it.message)
                serverToken = it.serverToken
                return it.commandComplicated
            }
        } catch (e: NotSerializableException) {
            println("error: Произошла ошибка при откправке данных на сервер!")
            return StateOfResponse.CLIENT_EXIT
        } catch (e: IOException) {
            println("error: Соединение с сервером разорвано!")
            return StateOfResponse.CLIENT_EXIT
        }
    }

    fun checkCommand(str: String): Boolean {
        return listOfCommands.contains(str)
    }

    fun checkSymbols(s1: String, s2: String): Boolean {
        if (s1 in listOf("help", "show", "info", "clear", "save", "exit", "history", "print_descending", "print_field_descending_view")) {
            return if (s2.isEmpty()) true
            else {
                DriverManager.println("Ошибка! У команды $s1 нет аргументов! Команда должна быть введена без них.")
                false
            }
        }
        if (s1 in listOf("update", "remove_by_id")) {
            return try {
                s2.toInt()
                true
            } catch (e: NumberFormatException) {
                DriverManager.println("Ошибка! id - это целочисленное значение.")
                false
            }
        }
        if (s1 in listOf("count_less_than_house")) {

        }
        if (s1 in listOf("execute_script")) {
            return if (File(s1).exists()) true
            else {
                DriverManager.println("Ошибка! Файл $s2 не найден!")
                false
            }
        }
        return false
    }

    private fun connectToServer() {
        try {
            sock = Socket("localhost", port)
            outputStream = ObjectOutputStream(sock.getOutputStream())
            inputStream = ObjectInputStream(sock.getInputStream())
        } catch (e: IOException) {
            println("error: Произошла ошибка при подключении к серверу!")
        }
    }

   /* private fun queue(temp: String) {
        if (last14.size < 13) {
            last14.add(temp)
        }
        else {
            for (i in 1..12) {
                last14[i-1] = last14[i]
            }
            last14.add(temp)
        }
    }

    fun history(): String {
        var temp = ""
        for (i in last14) {
            temp += i + "\t\n"
        }
        return temp.substring(0, temp.length - 2)
    }*/
}